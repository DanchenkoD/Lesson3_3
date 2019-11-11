package com.sbt.lesson3;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File file_ = new File("resources\\РАССВЕТ.txt");
            System.out.println(file_.getName() + file_.getPath() + file_.getAbsolutePath());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file_), "windows-1251"));
           /* FileInputStream fs = new FileInputStream( file_, StandardCharsets.UTF_8)
            FileReader fr = new FileReader(file_);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку*/
            String[] splitted;
            int cnt;
            cnt = 0;

            /*class SringTextComparator implements Comparator<String> {

                public int compare(String a, String b){

                    return a.compareTo(b);
                }
            }
            class SringLengthComparator implements Comparator<String>{

                public int compare(String a, String b){

                    if(a.length()> b.length())
                        return 1;
                    else if(a.length()< b.length())
                        return -1;
                    else
                        return 0;
                }
            }
            Comparator<String> scomp = new SringLengthComparator().thenComparing(new SringTextComparator());*/
            HashMap<String, Integer> words = new HashMap<>();
            //HashSet<String> words = new HashSet<>();
            String line = reader.readLine();
            while (line != null) {
                //line=line.replace(",","").replace(".","");
                splitted = line.replace(",", "").replace(".", "").replace("  "," ").split(" ");
                for (int i = 0; i < splitted.length; i++) {
                    if (words.containsKey(splitted[i].toLowerCase())) {
                        int value = words.get(splitted[i].toLowerCase());
                        words.put(splitted[i].toLowerCase(), value + 1);
                    } else {
                        words.put(splitted[i].toLowerCase(), 1);
                        cnt++;
                        //System.out.println(splitted[i]);
                    }
                    //System.out.println(splitted[i]);
                }

                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
            System.out.println("Количество слов: " + words.size() + " " + cnt);
            for (Map.Entry entry : words.entrySet()) {
                System.out.println("Key: " + entry.getKey() + " Value: "
                        + entry.getValue());
            }
            //while (words.iterator().hasNext()) {
            /*Iterator<String> i_ = words.iterator();
            while (i_.hasNext())
                System.out.print(i_.next() + ", ");*/
            //}
            //System.out.println(words);//.iterator().next()
            //words.iterator().;


           /* for (int i = 0; i < words.size(); i++) {
                System.out.println(words.);
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* Scanner sc = new Scanner(new File("resources\\РАССВЕТ.txt"));//resources\РАССВЕТ.txt
        int tempDay;
        String [] splitted;
        String tempMonth;
        while(sc.hasNext()){
            splitted = sc.nextLine().split(" ");
            for (int i = 0; i < splitted.length; i++) {
                System.out.println(splitted[0]);
            }

            tempDay = Integer.parseInt(splitted[0]);
            tempMonth = splitted[1];
            System.out.println(tempDay + "," + tempMonth);
        }*/

    }


}
