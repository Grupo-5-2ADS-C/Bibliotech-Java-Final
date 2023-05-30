package com.mycompany.tela.java.swing.v1;

import MetricaRede.MetricaRede;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author viniciuspereira
 */
public class Teste {

    public static void main(String[] args) throws InterruptedException {

        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConnection();
        Services d = new Services();
        Hardware hardware = d.enviarDados();
        Looca looca = new Looca();
        Sistema sistema = looca.getSistema();

        Double memoriaFormatada = d.memoria.getTotal().doubleValue() / 1073741824;
        String convertToString = String.format("%.2f", memoriaFormatada).replace(",", ".");
        
        System.out.println(convertToString);

    }

}
