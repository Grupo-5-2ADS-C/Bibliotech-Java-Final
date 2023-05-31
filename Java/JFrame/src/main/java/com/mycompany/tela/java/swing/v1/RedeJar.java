/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tela.java.swing.v1;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.rede.Rede;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import com.github.britooo.looca.api.group.rede.RedeInterfaceGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author wesley
 */
public class RedeJar {
    Looca looca = new Looca();
    Hardware hardware = new Hardware();
    Sistema sistema = new Sistema();
    Memoria memoria = new Memoria();
    DiscoGrupo discoGroup = looca.getGrupoDeDiscos();
    Volume volumeA = discoGroup.getVolumes().get(0);
    
    
    Disco disco = discoGroup.getDiscos().get(0);
    
    Rede rede = looca.getRede();
    RedeInterfaceGroup gruposDeInterface = rede.getGrupoDeInterfaces();
    List<RedeInterface> interfaces = gruposDeInterface.getInterfaces();
    RedeInterface redeDaVez = interfaces.stream().max(Comparator.comparing(RedeInterface::getBytesRecebidos)).orElse(null);

    
    private static double byteConverterMega(double bytes) {
        return bytes / (1024 * 1024);
    }
    
   

    long bytesRecebidosA = redeDaVez.getBytesRecebidos();
    long bytesEnviadosA = redeDaVez.getBytesEnviados();
     
    // Obtenha os bytes recebidos e enviados após 1 segundo
    long bytesRecebidosB = redeDaVez.getBytesRecebidos();
    long bytesEnviadosB = redeDaVez.getBytesEnviados();

    // Calcule a taxa de download e upload em bytes por segundo
    long bytesRecebidosPorSegundo = bytesRecebidosB - bytesRecebidosA;
    long bytesEnviadosPorSegundo = bytesEnviadosB - bytesEnviadosA;

// Aguarde 1 segundo

    public double calcularTaxaDownload(RedeInterface redeInterface) throws InterruptedException {
        long bytesRecebidosA = redeInterface.getBytesRecebidos();
        TimeUnit.SECONDS.sleep(1);
        long bytesRecebidosB = redeInterface.getBytesRecebidos();
        long bytesRecebidosPorSegundo = bytesRecebidosB - bytesRecebidosA;
        return byteConverterMega(bytesRecebidosPorSegundo);
    }
 
    public double calcularTaxaUpload(RedeInterface redeInterface) throws InterruptedException {
        long bytesEnviadosA = redeInterface.getBytesEnviados();
        TimeUnit.SECONDS.sleep(1);
        long bytesEnviadosB = redeInterface.getBytesEnviados();
        long bytesEnviadosPorSegundo = bytesEnviadosB - bytesEnviadosA;
        return byteConverterMega(bytesEnviadosPorSegundo);
    }
}