package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.UnexpectedException;

import util.Constants;

public class KillController {

    private final String os;

    public KillController() {
        this.os = os();
    }

    private String os() {
        return System.getProperty("os.name");
    }
    
    private Process executeProcess(String process) {
        try {
            return Runtime.getRuntime().exec(process);
        } catch (IOException e) {
             if (e.getMessage().contains("740")) {
                System.err.println("Você não tem acesso de administrador para executar este comando.");
            }
        }
        throw new RuntimeException("Não foi possível executar este comando: " + process);
    }
    
    public void taskList() throws IOException {
    	System.out.println("TASKLIST:");
    	Process process;
        if (os.contains("Windows")) {
        	process = executeProcess(Constants.TASKLIST_WINDOWS);
        }else if(os.contains("Linux")){
        	process = executeProcess(Constants.TASKLIST_LINUX);
        }else {
        	System.err.println("Sai daqui, usuário de Mac grrr");
        	throw new UnexpectedException("Proibido usuários de mac");
        }
        
		InputStream inputStream = process.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String linha = bufferedReader.readLine();
        
        while (linha != null) {
        	System.out.println(linha);
       	 linha = bufferedReader.readLine();
        }
        inputStream.close();
        inputStreamReader.close();
        bufferedReader.close();
    }
    
    public void killByPid(String pid) throws IOException {
    	 if (os.contains("Windows")) {
         	executeProcess(Constants.KILL_BY_PID_WINDOWS.concat(pid));
         }else if(os.contains("Linux")){
         	executeProcess(Constants.KILL_BY_PID_LINUX.concat(pid));
         }else {
         	System.err.println("Sai daqui, usuário de Mac grrr");
         	throw new UnexpectedException("Proibido usuários de mac");
         }
    	 System.out.println("Task matada com sucesso!!!");
    }

    public void killByName(String name) throws IOException {
   	 if (os.contains("Windows")) {
        	executeProcess(Constants.KILL_BY_NAME_WINDOWS.concat(name));
        }else if(os.contains("Linux")){
        	executeProcess(Constants.KILL_BY_NAME_LINUX.concat(name));
        }else {
        	System.err.println("Sai daqui, usuário de Mac grrr");
        	throw new UnexpectedException("Proibido usuários de mac");
        }
   	 System.out.println("Task matada com sucesso!!!");
   }
}
