package Beans;


import BeansDB.Historico;
import BeansDB.Valor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utils.BinaryOperations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pepe
 */
public class CoreAlgorithm {
    
    private List<Portfolio> portfolios;
    private List<Historico> historicos;
    private Portfolio bestPortfolio;
    private List<Valor> valores;
    private int populationSize;
    
    
    /**
     * 
     * @param time en dias
     * @param money en pesos mexicanos
     * @param interes en rendimiento anual
     */
    public CoreAlgorithm(int time, double money, ValoresActivos va, int populationSize, List<Historico> historicos, List<Valor> valores){
        
        portfolios = new ArrayList<>();
        this.historicos = historicos;
        this.valores = valores;
        bestPortfolio = new Portfolio();
        bestPortfolio.setAptitud(0);
        
        
        initialPopulation(populationSize, va);        
        
        calcularAptitudTodos(portfolios, historicos, valores, time);
        
        
        //ETAPA 3
        //CRUZA
        cross(portfolios, populationSize, time, va);
        
        //ETAPA 4
        //MUTACIÓN
        
    }

    private void initialPopulation(long populationSize, ValoresActivos valoresActivos) {
        
        Random random = new Random();
        BinaryOperations bo = new BinaryOperations();
        

        for (int i = 0; i < populationSize; i++) {
            
            Portfolio portfolio = new Portfolio();
                    
            //ETAPA 1 
            // CREAR UNA POBLACIÓN ALEATORIA
            long aux_part1 = random.nextLong();
            long aux_part2 = random.nextLong();
            
            if (aux_part1 < 0) {
                aux_part1 *= -1;
            }
            if (aux_part2 < 0) {
                aux_part2 *= -1;
            }
            
            //ADECUARLAS AL 100%
            long firstpart = bo.setId(aux_part1, aux_part2, valoresActivos.getVariable());
            int porcentaje = 0;
            for (int j = 0; j < 9; j++) {
                porcentaje += bo.getPercentage(firstpart, j);
            }
            long secondpart = bo.aquote_part2(aux_part2, 100-porcentaje, valoresActivos.getVariable(1));
            
            portfolio.setId_part1(firstpart);
            portfolio.setId_part2(secondpart);
            
            portfolios.add(portfolio);
        }
        
        
    }   

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    
    private void cross(List<Portfolio> portfolios, int populationSize, int time, ValoresActivos valoresActivos) {
        
        Random random = new Random();
        List<Portfolio> newPortfolios = new ArrayList<> ();
        Portfolio a, b, porpose1, porpose2;
        BinaryOperations bo = new BinaryOperations();
        int porcentaje;
        
        while (this.portfolios.size()>0) {            
            
            a = portfolios.remove(random.nextInt(populationSize--));
            b = portfolios.remove(random.nextInt(populationSize--));

            porpose1 = new Portfolio(a.getId_part1(),b.getId_part2());
            porpose2 = new Portfolio(b.getId_part1(),a.getId_part2());

            porpose1 = calcularAptitud(porpose1, historicos, valores, time);
            porpose2 = calcularAptitud(porpose2, historicos, valores, time);

            porcentaje = 0;
            for (int j = 0; j < 9; j++) {
                porcentaje += bo.getPercentage(porpose1.getId_part1(), j);
            }
            porpose1.setId_part2(bo.aquote_part2(porpose1.getId_part2(), 100-porcentaje, valoresActivos.getVariable(1)));

            porcentaje = 0;
            for (int j = 0; j < 9; j++) {
                porcentaje += bo.getPercentage(porpose2.getId_part1(), j);
            }
            porpose2.setId_part2(bo.aquote_part2(porpose2.getId_part2(), 100-porcentaje, valoresActivos.getVariable(1)));

            if (a.getAptitud() > porpose1.getAptitud()) {
                newPortfolios.add(a);
            } else {
                newPortfolios.add(porpose1);
            }
            if (b.getAptitud() > porpose2.getAptitud()) {
                newPortfolios.add(b);
            } else {
                newPortfolios.add(porpose2);
            }
        }
    }

    private void calcularAptitudTodos(List<Portfolio> portfolios, List<Historico> historicos, List<Valor> valores, int time) {
        
        BinaryOperations bo = new BinaryOperations();
        
        for (Portfolio portfolio : portfolios) {
            
            long id_part1 = portfolio.getId_part1();
            long id_part2 = portfolio.getId_part2();
            float aptitud = 0;
            
            for (int i = 0; i < 9; i++) {
                
                float tasa = historicos.get(i).getTasa();
                int plazo = historicos.get(i).getPlazo();
                int plazo_completo = valores.get(i).getPlazo_completo();
                //variable tiempo
                
                long percentage = bo.getPercentage(id_part1, i);
                aptitud += percentage * tasa;
                System.out.println("int " + i +" time " + time);
                int complete_Time = time-plazo;
                
                while (complete_Time > plazo_completo) {
                    System.out.println("completeTime " + complete_Time);
                    aptitud += (percentage * tasa);
                    complete_Time -= plazo_completo;
                }
            }
            
            for (int i = 9; i < 18; i++) {
                
                float tasa = historicos.get(i).getTasa();
                int plazo = historicos.get(i).getPlazo();
                int plazo_completo = valores.get(i).getPlazo_completo();
                //variable tiempo
                
                long percentage = bo.getPercentage(id_part2, i);
                aptitud += (percentage * tasa);
                int complete_Time = time-plazo;
                
                while (complete_Time < plazo_completo) {
                    aptitud += (percentage * tasa);
                    complete_Time -= plazo_completo;
                }
            }
            portfolio.setAptitud(aptitud/100);
            checkBestPortfolio(portfolio);
        }
    }
    
    private Portfolio calcularAptitud(Portfolio portfolio, List<Historico> historicos, List<Valor> valores, int time) {
        BinaryOperations bo = new BinaryOperations();            
        long id_part1 = portfolio.getId_part1();
        long id_part2 = portfolio.getId_part2();
        float aptitud = 0;
            
        for (int i = 0; i < 9; i++) {
            float tasa = historicos.get(i).getTasa();
            int plazo = historicos.get(i).getPlazo();
            int plazo_completo = valores.get(i).getPlazo_completo();
            //variable tiempo
                
            long percentage = bo.getPercentage(id_part1, i);
            aptitud += percentage * tasa;
            System.out.println("int " + i +" time " + time);
            int complete_Time = time-plazo;
             
            while (complete_Time > plazo_completo) {
                System.out.println("completeTime " + complete_Time);
                aptitud += (percentage * tasa);
                 complete_Time -= plazo_completo;
            }
        }
            
        for (int i = 9; i < 18; i++) {
              
            float tasa = historicos.get(i).getTasa();
            int plazo = historicos.get(i).getPlazo();
            int plazo_completo = valores.get(i).getPlazo_completo();
            //variable tiempo
               
            long percentage = bo.getPercentage(id_part2, i);
            aptitud += (percentage * tasa);
            int complete_Time = time-plazo;
                
            while (complete_Time < plazo_completo) {
                aptitud += (percentage * tasa);
                complete_Time -= plazo_completo;
            }
        }
        portfolio.setAptitud(aptitud/100);
        checkBestPortfolio(portfolio);
            
        return portfolio;
    }
    
    private void checkBestPortfolio(Portfolio portfolio) {
        if (bestPortfolio.getAptitud() < portfolio.getAptitud()) {
            bestPortfolio = portfolio;
        }
        
    }
}