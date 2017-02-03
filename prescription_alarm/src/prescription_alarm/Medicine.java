/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prescription_alarm;

import java.time.LocalDate;


/**
 *
 * @author Nafisa
 */

/**
 * Model class for a Medicine information.
 *
 * @author Nafisa
 */
public class Medicine {
    private String MedicineName;
    private String Instructions;
    private int Dose;
    private int ContinueFor;
    private int repeat;
    private int Hours;
    private int Minutes;
    private String Start;
    

    /**
     * Default constructor.
     */
    public Medicine() {
        this.MedicineName= "";
        this.Instructions= "";
        this.Dose=0;
        this.ContinueFor=0;
        this.repeat=0;
        this.Hours=0;
        this.Minutes=0;
        this.Start="";
                
    }

    public Medicine(String MedicineName, String Instructions, int Dose, int ContinueFor, int repeat, int Hours, int Minutes, String date) {
        this.MedicineName = MedicineName;
        this.Instructions = Instructions;
        this.Dose = Dose;
        this.ContinueFor = ContinueFor;
        this.repeat = repeat;
        this.Hours = Hours;
        this.Minutes = Minutes;
        this.Start = date;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String Start) {
        this.Start = Start;
    }

    public String getMedicineName() {
        return MedicineName;
    }
    public void setMedicineName(String MedicineName){
        this.MedicineName = MedicineName;
    }

    public String getInstructions() {
        return Instructions;
    }
    public void setInstructions(String Instructions){
        this.Instructions = Instructions;
    }

    public int getDose() {
        return Dose;
    }

    /**
     *
     * @param Dose
     */
    public void setDose(int Dose){
        this.Dose = Dose;
    }

    public int getContinueFor() {
        return ContinueFor;
    }
    public void setContinueFor(int ContinueFor){
        this.ContinueFor = ContinueFor;
    }

    public int getrepeat() {
        return repeat;
    }

    /**
     *
     * @param repeat
     */
    public void setrepeat(int repeat){
        this.repeat = repeat;
    }

    public int getHours() {
        return Hours;
    }

    public void setHours(int Hours) {
        this.Hours = Hours;
    }

    public int getMinutes() {
        return Minutes;
    }

    public void setMinutes(int Minutes) {
        this.Minutes = Minutes;
    }
  
}
