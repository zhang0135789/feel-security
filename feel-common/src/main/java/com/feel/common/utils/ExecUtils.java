package com.feel.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: zz
 * @Description:
 * @Date: 10:49 PM 4/15/19
 * @Modified By
 */
public class ExecUtils {


    public static String exec(String cmd) throws IOException {
        StringBuilder result = new StringBuilder();
        String[] cmds = {"/bin/sh" , "-c" , cmd };

        Process process = Runtime.getRuntime().exec(cmds);
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }catch (IOException e) {

        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return result.toString();
    }



    public static void main(String[] args) throws IOException, InterruptedException {
        String[] cmd = {"/bin/sh", "-c", "ps -elf | grep -v grep | grep idea | wc -l"};
        while (true) {
            StringBuilder sb = new StringBuilder();
            Process process1 = null;
            process1 = Runtime.getRuntime().exec(cmd);
            BufferedReader input = new BufferedReader(new InputStreamReader(process1.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                sb.append(line);
            }
            input.close();
            if ("0".equals(sb.toString().trim())) {
                break;
            }
            Thread.sleep(300000);
        }
    }
}
