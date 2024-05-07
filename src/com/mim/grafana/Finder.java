package com.mim.grafana;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;

public class Finder{
    private List<File> childsFile;


    public Finder(String base){
        this(new File(base));
    }

    public Finder(File base) {
        childsFile = findChilds(base);
    }


    private List<File> findChilds(File origin){
        List<File> result = new ArrayList<>();
        if (origin.isFile())
            result.add(origin); 
        else if (origin.isDirectory())
            for( File child : origin.listFiles()){
                List<File> actual = findChilds(child);
                if(actual != null)
                    result.addAll(actual);
            }
        else
            return null;
        return result;
    } 

    public void filterByExtension(String extension){
        List<File> result = new ArrayList<>();
        for(File f : childsFile){
            if(f.getName().endsWith(extension))
                result.add(f);
        }
        childsFile = result;
    }

    public void filterByContent(String content){
        List<File> result = new ArrayList<>();
        for(File f : childsFile){
            try(Scanner sc = new Scanner(f)) {
                StringBuilder inner = new StringBuilder();
                while (sc.hasNextLine()) {
                    inner.append(sc.nextLine());
                }
                if(inner.toString().contains(content)) 
                    result.add(f);
            } catch (Exception e) {
                return;
            }
        }
        childsFile = result;
    }

    public void translateAll(OrderedMap<String,String> translateMap){
        for(File f : childsFile){
            try(Scanner sc = new Scanner(f)){
                StringBuilder inner = new StringBuilder();
                while (sc.hasNextLine()) {
                    inner.append(sc.nextLine() + "\n");
                }
                String s = inner.toString();
                for(String key : translateMap.keyList()){
                    s = s.replace(key, translateMap.get(key));
                }
                PrintWriter writer = new PrintWriter(f);
                writer.println(s);
                writer.close();
            } catch (Exception e) {}
        }
    }

    public List<File> getFiles(){
        return childsFile;
    }

    public void printFiles(){
        for(File f : childsFile){
            System.out.println("TRADUCTION : " + f.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        Finder f = new Finder("C:\\Users\\Baptiste\\Desktop\\GrafanaGit");
        f.filterByContent("Last 30 days");
        f.printFiles();
        System.out.println("FIN");
    }

}