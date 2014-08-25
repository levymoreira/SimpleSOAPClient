package com.levymoreira;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.levymoreira.ws.Produto;
import com.levymoreira.ws.WebServiceInterface;
/**
 * Apos atualizar o servidor, suba ele e a partir da pasta bin do seu JAVA_HOME rode o comando:
 * 
 * wsimport.exe -keep http://localhost:8080/SimpleSOAPServer/teste?wsdl -d C:\WorkSpace\SimpleSOAPClient\src
 * 
 * @author Levy Moreira
 *
 */
public class WebServiceClient{

	public static void main(String[] args) throws Exception {

	    URL wsdlUrl = new URL("http://localhost:8080/SimpleSOAPServer/teste?wsdl");

        QName qname = new QName("http://ws.levymoreira.com/", "WebServiceImplService"); //nome do pacote e nome da classe

        Service service = Service.create(wsdlUrl, qname);

        WebServiceInterface helloWorldInterface = service.getPort(WebServiceInterface.class);

        Produto p = new Produto();
        p.setId(222);
        p.setNome("PRODUTO NO CLIENTE");
        
        Produto retorno = helloWorldInterface.printMessage(p);
        System.out.println(retorno.getId() + " - " + retorno.getNome()); 
   } 
}