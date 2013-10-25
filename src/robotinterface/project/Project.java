/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robotinterface.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import robotinterface.algorithm.parser.Parser;
import robotinterface.algorithm.procedure.Function;
import robotinterface.interpreter.Interpreter;

/**
 *
 * @author antunes
 */
public class Project {

    public static void main(String[] args) {

//        Project a = new Project("teste");
//        a.save("teste.zip");

    }
    private ArrayList<Function> functions;
    private boolean exists;

    public Project(String name, ArrayList<Function> functions) {
        this.functions = functions;
    }

    public boolean save(String path) {
        boolean result = false;
        ZipOutputStream zip;
        FileOutputStream fileWriter;

        if (exists) {
            System.out.println("Não Implementado... Ainda");
        } else {

            try {
                System.out.println("Program Start zipping");

                /*
                 * create the output stream to zip file result
                 */
                fileWriter = new FileOutputStream(path);
                zip = new ZipOutputStream(fileWriter);
                /*
                 * add the folder to the zip
                 */
                addFolderToZip("", "functions", zip);

                for (Function f : functions){
                    addFileToZip("functions", functionToFile(f), zip, false);
                }
                /*
                 * close the zip objects
                 */
                zip.flush();
                zip.close();

                result = true;
                System.out.println("Given files are successfully zipped");
            } catch (Exception e) {
                System.out.println("Some Errors happned during the zip process");
                e.printStackTrace();
            }
        }
        return result;
    }

    private File functionToFile(Function f) {
        File file = null;
        try {
            String str = Parser.encode(f);
            file = new File(f.getName()+".func");

            FileWriter fw = new FileWriter(file);
            fw.write(str);
            fw.close();

        } catch (Exception e) {
            //do stuff with exception
            e.printStackTrace();
        }
        return file;
    }

    /*
     * recursively add files to the zip files
     */
    private void addFileToZip(String path, File file, ZipOutputStream zip, boolean flag) throws Exception {

        /*
         * if the folder is empty add empty folder to the Zip file
         */
        if (flag == true) {
            zip.putNextEntry(new ZipEntry(path + "/" + file.getName() + "/"));
        } else { /*
             * if the current name is directory, recursively traverse it
             * to get the files
             */
            if (file.isDirectory()) {
                /*
                 * if folder is not empty
                 */
                addFolderToZip(path, file.getPath(), zip);
            } else {
                /*
                 * write the file to the output
                 */
                byte[] buf = new byte[1024];
                int len;
                FileInputStream in = new FileInputStream(file.getPath());
                zip.putNextEntry(new ZipEntry(path + "/" + file.getName()));
                while ((len = in.read(buf)) > 0) {
                    /*
                     * Write the Result
                     */
                    zip.write(buf, 0, len);
                }
            }
        }
        
        if (file.delete()){
            System.out.println(file.getName() + " is deleted!");
        } else {
            System.out.println("Delete operation is failed.");
        }
    }

    /*
     * add folder to the zip file
     */
    private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) throws Exception {
        File folder = new File(srcFolder);

        /*
         * check the empty folder
         */
        if (folder.list() == null || folder.list().length == 0) {
            System.out.println(folder.getName());
            addFileToZip(path, new File(srcFolder), zip, true);
        } else {
            /*
             * list the files in the folder
             */
            for (String fileName : folder.list()) {
                if (path.equals("")) {
                    addFileToZip(folder.getName(), new File(srcFolder + "/" + fileName), zip, false);
                } else {
                    addFileToZip(path + "/" + folder.getName(), new File(srcFolder + "/" + fileName), zip, false);
                }
            }
        }
    }

    public Project load(String path) {
        return null;
    }
}