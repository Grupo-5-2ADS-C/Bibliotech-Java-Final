/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogsBibliotech;

import TipoAlerta.*;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import com.mycompany.tela.java.swing.v1.Conexao;
import com.mycompany.tela.java.swing.v1.Hardware;
import com.mycompany.tela.java.swing.v1.Services;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author viniciuspereira
 */
public class Logs {
    
    private static final Logger logger = Logger.getLogger(Logs.class.getName());

    public Logs() {
    }
    Services d = new Services();
        Hardware hardware = new Hardware();
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConnection();
        
        Looca looca = new Looca();
        Processador processador = new Processador();

        String diretorio = "C:\\Logs";
        String nomeArquivo = "LogsAlertas.txt";

        public void gerarLogs() throws IOException,InterruptedException{
        // Criar o diretÃ³rio, se nÃ£o existir
        Path diretorioLogs = Paths.get(diretorio);
        if (!Files.exists(diretorioLogs)) {
            Files.createDirectories(diretorioLogs);
        }

        // Criar o arquivo no diretório
        File arquivo = new File(diretorio, nomeArquivo);
        arquivo.createNewFile();

        // Criar o FileOutputStream para o arquivo
        FileOutputStream arq = new FileOutputStream(arquivo);
        DataOutputStream gravarArq = new DataOutputStream(arq);

        Integer idAlerta = 1; // Exemplo de valor para idAlerta
        String situacaoAlerta = "Ativo"; // Exemplo de valor para nome
        Double pc = 123.45; // Exemplo de valor para pc
        Integer idSituacaoAlerta = 0; // Exemplo de valor para altura

        gravarArq.writeInt(idAlerta);
        gravarArq.writeUTF(situacaoAlerta);
        gravarArq.writeDouble(pc);
        gravarArq.writeInt(idSituacaoAlerta);

        try {
            Date dateTime = new Date();
            

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String formattedDateTime = dateFormat.format(dateTime);

            gravarArq.writeUTF(formattedDateTime);

            
            FileWriter fileWriter = null;
            String alertaData = null;

            try {
                fileWriter = new FileWriter(arquivo);
                FileHandler fileHandler = new FileHandler(diretorio + "\\monitoramento.log");
                logger.addHandler(fileHandler);
                SimpleFormatter formatter = new SimpleFormatter();
                fileHandler.setFormatter(formatter);
                
                if(processador.getUso() <= 2.0){ 
                    
                    logger.info("InformaÃ§Ã£o de alerta:" + 1 + "(Ociosidade)");
                    
                 }else if(processador.getUso() >= 50.0){ 
                    
                    logger.info("InformaÃ§Ã£o de alerta: " + 2 + " (Mal uso)");
                    
                }

             logger.info("Logs gravados com sucesso!");
            } catch (IOException e) {
                e.printStackTrace();
                logger.severe("Erro ao gravar logs: " + e.getMessage());
            } finally {
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.severe("Erro ao fechar FileWriter: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Erro ao gravar logs: " + e.getMessage());
        } finally {
            if (gravarArq != null) {
                try {
                    gravarArq.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.severe("Erro ao fechar DataOutputStream: " + e.getMessage());
                }
            }
            if (arq != null) {
                try {
                    arq.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.severe("Erro ao fechar FileOutputStream: " + e.getMessage());
                }
            }
        }
    }
}