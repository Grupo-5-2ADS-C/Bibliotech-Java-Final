package com.mycompany.tela.java.swing.v1;

import LogsBibliotech.LogsBibliotech;
import Alerta.Alerta;
import ComponenteMaquina.*;
import ConexaoMySQL.ConexaoSQL;
import EspecificacaoComponenteMaquina.EspecificacaoComponenteMaquina;
import Metrica.*;
import SituacaoAlerta.*;
import TipoAlerta.*;


// Autenticacao
//import Autenticacao.Login;
//import Autenticacao.LoginRowMapper;
import Maquina.*;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author viniciuspereira
 */
public class TelaLogin extends javax.swing.JFrame {
    
    private String webHookUrl = "https://hooks.slack.com/services/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";
    private String oAuthUrl = "xoxb-5093777488852-5347584044833-rXCGMQtLQb13bfP1BAm08m8q";
    private String slackChannelUrl = "monitoramento-de-máquinas";

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        iptLogin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        iptPassword = new javax.swing.JPasswordField();
        buttonLogin = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(87, 180, 206));
        jPanel3.setForeground(new java.awt.Color(87, 180, 206));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("BiblioTech");
        jLabel4.setAlignmentX(0.5F);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/logo bibliotech 67px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(110, 110, 110))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel2.setText("Login");
        jLabel2.setAlignmentX(0.5F);

        iptLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iptLoginActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel3.setText("Senha");
        jLabel3.setAlignmentX(0.5F);

        iptPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iptPasswordActionPerformed(evt);
            }
        });

        buttonLogin.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(iptLogin)
                    .addComponent(jLabel3)
                    .addComponent(iptPassword)
                    .addComponent(buttonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addGap(0, 65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iptLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iptPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonLogin)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iptLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iptLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iptLoginActionPerformed

    private void iptPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iptPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iptPasswordActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed

        
        //Aqui se passa a mensagem para o metodo
        
        Looca looca = new Looca();
        Services d = new Services();
        Conexao conexao = new Conexao();
        Maquina maquina = new Maquina();
        Sistema sistema = looca.getSistema();
        Alerta alerta = new Alerta();
        LogsBibliotech log = new LogsBibliotech();

        // Pegando dados da input
        String getLogin = iptLogin.getText();
        String getSenha = iptPassword.getText();

        // Conexões necessárias
        ConexaoSQL conexaoMySQL = new ConexaoSQL();
        JdbcTemplate con = conexao.getConnection();
        JdbcTemplate conMysql = conexaoMySQL.getConnection();

        // Buscando login e senha digitados no JFrame
        List<Maquina> searchLogin = con.query("select id_maquina,sistema_operacional,setor,login,senha,fk_biblioteca from maquina where login = ? and senha = ?;", new BeanPropertyRowMapper(Maquina.class), getLogin, getSenha);
        Maquina result = searchLogin.get(0);

        // Começando os inserts dos dados, caso o Login e a Senha estejam corretos
        if (searchLogin.size() > 0) {
            SucessoLogin success = new SucessoLogin();
            sendToSlack("Maquina com id " + result.getId_maquina() + " Iniciada!");
            success.setVisible(true);
            dispose();

            // Inserts na tabela componente_maquina
            ComponenteMaquina componente1 = new ComponenteMaquina("Processador", d.processador.getNome(), d.processador.getFabricante());
            ComponenteMaquina componente2 = new ComponenteMaquina("Memoria ram", (d.memoria.getTotal().doubleValue() / 1048576), "null");
            ComponenteMaquina componente3 = new ComponenteMaquina("Disco", d.disco.getModelo(), "null");

            con.update(String.format("insert into componente_maquina (tipo,descricao,fabricante) values ('%s','%s','%s')",
                    componente1.getTipo(), componente1.getDescricao(), componente1.getFabricante()));

            DecimalFormat df = new DecimalFormat("0.00");
            Double numero = Double.valueOf(componente2.getDescricao());
            String saida = df.format(numero);

            con.update(String.format("insert into componente_maquina (tipo,descricao,fabricante) values ('%s','%s','%s')",
                    componente2.getTipo(), saida, componente2.getFabricante()));

            con.update(String.format("insert into componente_maquina (tipo,descricao,fabricante) values ('%s','%s','%s')",
                    componente3.getTipo(), componente3.getDescricao(), componente3.getFabricante()));

            // Pegando os últimos 3 componentes da lista de componentes para usar como fk
            List<ComponenteMaquina> comp = con.query("select id_componente_maquina from componente_maquina order by id_componente_maquina desc;", new BeanPropertyRowMapper(ComponenteMaquina.class));
            ComponenteMaquina resultComp = comp.get(0);
            ComponenteMaquina resultComp1 = comp.get(1);
            ComponenteMaquina resultComp2 = comp.get(2);

            // Coletando os dados das especificações dos componentes
            EspecificacaoComponenteMaquina spec1 = new EspecificacaoComponenteMaquina(d.processador.getId(), d.processador.getUso(), ((d.processador.getFrequencia().doubleValue()) / 1048576));
            EspecificacaoComponenteMaquina spec2 = new EspecificacaoComponenteMaquina("null", (d.memoria.getTotal().doubleValue() / 1048576), null);
            EspecificacaoComponenteMaquina spec3 = new EspecificacaoComponenteMaquina(d.disco.getSerial(), (d.discoGroup.getTamanhoTotal().doubleValue() / 1000000000), null);

            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            DecimalFormatSymbols symbols = decimalFormat.getDecimalFormatSymbols();

            // Inserts de processador
            
            String processadorUsoFormatado = df.format(spec1.getUso_maximo());  
            String processadorFrequenciaFormatada = df.format(spec1.getFreq_maxima());

            
            con.update(String.format("insert into especificacao_componente_maquina (fk_componente_maquina ,fk_maquina, numero_serial, uso_maximo, freq_maxima) values (%d, %d, '%s','%s','%s')",
                    resultComp2.getId_componente_maquina(), result.getId_maquina(), spec1.getNumero_serial(), processadorUsoFormatado.replace(',','.'),processadorFrequenciaFormatada.replace(',','.') ));
            // memoria
            double usoMaximoRam = spec2.getUso_maximo();
            String usoMaximoFormatado2 = String.format("%.2f",usoMaximoRam);
            System.out.println(usoMaximoFormatado2);   
            con.update(String.format("insert into especificacao_componente_maquina (fk_componente_maquina ,fk_maquina, numero_serial, uso_maximo, freq_maxima) values (%d, %d, '%s','%s', null)",
                    resultComp1.getId_componente_maquina(), result.getId_maquina(), spec2.getNumero_serial(), usoMaximoFormatado2.replace(',','.')));
 
            // Disco
            double usoMaximo3 = spec3.getUso_maximo();
            symbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(symbols);
            String usoMaximoFormatado3 = decimalFormat.format(usoMaximo3);
            // Verificar se o valor formatado é um número válido
            try {
                Double.parseDouble(usoMaximoFormatado3);
            } catch (NumberFormatException e) {
                // Tratar o caso em que o valor não é um número válido
                // Por exemplo, mostrar uma mensagem de erro ou definir um valor padrão
                usoMaximoFormatado3 = "0.00"; // Valor padrão
            }

            con.update(String.format("insert into especificacao_componente_maquina (fk_componente_maquina, fk_maquina, numero_serial, uso_maximo, freq_maxima) values (%d, %d, '%s', '%s', null)",
        resultComp.getId_componente_maquina(), result.getId_maquina(), spec3.getNumero_serial(), usoMaximoFormatado3));

            
            // Pegando as últimas 3 especificações da lista para utilizar como fk
            List<EspecificacaoComponenteMaquina> spec = con.query("select id_especificacao from especificacao_componente_maquina order by id_especificacao desc;",
                    new BeanPropertyRowMapper(EspecificacaoComponenteMaquina.class));
            EspecificacaoComponenteMaquina resultSpec = spec.get(0);
            EspecificacaoComponenteMaquina resultSpec1 = spec.get(1);
            EspecificacaoComponenteMaquina resultSpec2 = spec.get(2);

            Boolean validar = true;

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dispose();

            do {

                Hardware hardware = new Hardware();

                try {
                    hardware = d.enviarDados();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                }

                String convertToString = String.format("%.2f", d.metricaRede.getVelocidade_download()).replace(",", ".");
                String convertToString1 = String.format("%.2f", d.metricaRede.getVelocidade_upload()).replace(",", ".");

                con.update(String.format("INSERT INTO metrica (uso, frequencia, fk_especificacao, fk_componente_maquina, fk_maquina, total_processos, tempo_de_sessão) VALUES (%s, %s, %d, %d, %d, %s, %d)",
                        hardware.getUsoCPU(), hardware.getFrequenciaCPU(), resultSpec2.getId_especificacao(), resultComp2.getId_componente_maquina(), result.getId_maquina(), hardware.getTotal_processos(), sistema.getTempoDeAtividade()));

                con.update(String.format("INSERT INTO metrica (uso, frequencia, fk_especificacao, fk_componente_maquina, fk_maquina, total_processos) VALUES (%s, null, %d, %d, %d, %s)",
                        (hardware.getUsoRAM()), resultSpec1.getId_especificacao(), resultComp1.getId_componente_maquina(), result.getId_maquina(), hardware.getTotal_processos()));

                con.update(String.format("INSERT INTO metrica (uso, frequencia, fk_especificacao, fk_componente_maquina, fk_maquina, total_processos) VALUES ('%s', '%s', %d, %d, %d, %s)",
                        d.getUsoDisco(), d.getFreqDisco(), resultSpec.getId_especificacao(), resultComp.getId_componente_maquina(), result.getId_maquina(), hardware.getTotal_processos()));

                con.update(String.format("INSERT INTO metrica_rede (velocidade_download, velocidade_upload, fk_maquina) values ('%s', '%s', %d)", convertToString,
                        convertToString1, result.getId_maquina()));
                
                d.Alerta();

                List<Metrica> metricaList = con.query("select id_metrica from metrica order by id_metrica desc", new BeanPropertyRowMapper(Metrica.class));
                Metrica metrica = metricaList.get(0);

                List<SituacaoAlerta> situacaoList = con.query("select id_situacao_alerta from situacao_alerta order by id_situacao_alerta desc", new BeanPropertyRowMapper(SituacaoAlerta.class));
                SituacaoAlerta situacao = situacaoList.get(0);
                SituacaoAlerta situacao1 = situacaoList.get(1);
                SituacaoAlerta situacao2 = situacaoList.get(2);
                SituacaoAlerta situacao3 = situacaoList.get(3);

                List<TipoAlerta> tipoList = con.query("select id_tipo_alerta from tipo_alerta order by id_tipo_alerta desc", new BeanPropertyRowMapper(TipoAlerta.class));
                TipoAlerta tipo = tipoList.get(0);
                TipoAlerta tipo1 = tipoList.get(1);

                if (d.processador.getUso() >= 90.0) {
                    sendToSlack("Maquina com id " + result.getId_maquina() + " localizada no setor " + result.getSetor() + " está com uso de CPU acima de 90%! (CRITICO)");
                    con.update(String.format("INSERT INTO alerta (texto_aviso, fk_metrica, fk_tipo_alerta, fk_situacao_alerta) values ('Alerta crítico. Uso muito acima do esperado.', %d, %d, %d)", metrica.getId_metrica(),
                            tipo1.getId_tipo_alerta(), situacao3.getId_situacao_alerta()));
                    
                    try {
                        log.gerarLogs();
                    } catch (IOException ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                       
                    
                    
                } else if (d.processador.getUso() >= 70.0) {
                     sendToSlack("Maquina com id " + result.getId_maquina() + " localizada no setor " + result.getSetor() + " está com uso de CPU acima de 70% (Risco alto)");
                    con.update(String.format("INSERT INTO alerta (texto_aviso, fk_metrica, fk_tipo_alerta, fk_situacao_alerta) values ('Risco alto. Uso acima do esperado.', %d, %d, %d)", metrica.getId_metrica(),
                            tipo1.getId_tipo_alerta(), situacao2.getId_situacao_alerta()));
                    
                      try {
                        log.gerarLogs();
                    } catch (IOException ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      
                } else if (d.processador.getUso() >= 50.0) {
                    sendToSlack("Maquina com id " + result.getId_maquina() + " localizada no setor " + result.getSetor() + " está com uso de CPU acima de 50% (Risco moderado)");
                    con.update(String.format("INSERT INTO alerta (texto_aviso, fk_metrica, fk_tipo_alerta, fk_situacao_alerta) values ('Risco moderado. Uso um pouco acima do esperado.', %d, %d, %d)", metrica.getId_metrica(),
                            tipo1.getId_tipo_alerta(), situacao1.getId_situacao_alerta()));
                    
                      try {
                        log.gerarLogs();
                    } catch (IOException ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      
                } else {

                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if (d.processador.getUso() < 2.0) {
                    sendToSlack("Maquina com id " + result.getId_maquina() + " localizada no setor" + result.getSetor() +  " está sendo bloqueada por ociosidade (Ocioso)");
                    con.update(String.format("INSERT INTO alerta (texto_aviso, fk_metrica, fk_tipo_alerta, fk_situacao_alerta) values ('Máquina ociosa.', %d, %d, %d)", metrica.getId_metrica(),
                            1,situacao.getId_situacao_alerta()));
                    ProcessBuilder Alertar = new ProcessBuilder("/bin/bash", "-c", "notify-send ALERTA 'Tela está sendo bloqueada por inatividade'");
                    ProcessBuilder bloquearTela;
                    if (sistema.getSistemaOperacional().equalsIgnoreCase("Windows")) {
                        bloquearTela = new ProcessBuilder("cmd.exe", "-c", "rundll32.exe user32.dll,LockWorkStation");
                    } else {
                        bloquearTela = new ProcessBuilder("/bin/bash", "-c", "xdg-screensaver lock");
                    }
                    try {
                        Process alertar = Alertar.start();
                    } catch (IOException ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        Thread.sleep(5000);
                        Process bloquear = bloquearTela.start();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    validar = false;
                }
            } while (validar == true);

        } else {
            FalhaLogin fail = new FalhaLogin();
            fail.setVisible(true);

        }

    }//GEN-LAST:event_buttonLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });

    }
    
    //Metodo para enviar mensafem para o slack
    public void sendToSlack(String mensagem) {

        try {
            StringBuilder msgbuilder = new StringBuilder();
            msgbuilder.append(mensagem);

            Payload payload = Payload.builder().channel(slackChannelUrl).text(msgbuilder.toString()).build();

            WebhookResponse wbResp = Slack.getInstance().send(webHookUrl, payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JTextField iptLogin;
    private javax.swing.JPasswordField iptPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}