/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jifi.ui.main;

import jifi.project.Project;

/**
 *
 * @author antunes2
 */
public class Model {
    
    private Project currentProject;
    
    public Model (){
        init();
    }
    
    public final void init(){
        
    }
    
    public void newProject(){
        currentProject = new Project("Projeto Vazio");
    }
    
    public void openProject(){
        
    }
    
    public void saveProject(){
        
    }
    
    public boolean exit(){
        return true;
    }
    
    
    
}
