package com.mycompany.tela.java.swing.v1;

import MetricaRede.MetricaRede;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import org.springframework.jdbc.core.JdbcTemplate;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import java.util.List;

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

        Rede rede = looca.getRede();
        List<RedeInterface> interfaces = rede.getGrupoDeInterfaces().getInterfaces();
        
        // Verificar se existem interfaces de rede disponíveis
        if (interfaces.isEmpty()) {
            System.out.println("Não foram encontradas interfaces de rede.");
            return;
        }
        
        System.out.println(interfaces.size());
        
        // Selecionar a interface de rede desejada (índice 3)
        RedeInterface redeInterface = interfaces.get(0);
        
        RedeJar redeObj = new RedeJar();
        
        Double download = redeObj.calcularTaxaDownload(redeInterface);
        Double upload = redeObj.calcularTaxaUpload(redeInterface);

        System.out.println("Download: " + download + " MB");
        System.out.println("Upload: " + upload + " MB");
        
        Double download2 = d.getDownload();
        Double upload2 = d.getUpload();
        
        System.out.println(download2);
        System.out.println(upload2);
        
        //Double memoriaFormatada = d.memoria.getTotal().doubleValue() / 1073741824;
        //String convertToString = String.format("%.2f", memoriaFormatada).replace(",", ".");
        
        //System.out.println(convertToString);
        
        

    }

}
