package onethirteen;   		//a11
import java.util.*;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

interface ISignUp{
    public void print();
    public boolean addStudent (int stuType);     
}
interface IParams<T> {
    public int getBig();
    public int getMedium();
    public int getSmall();
    public ArrayList<Integer>getPlanSignUp();
}
public class SchoolSystem implements ISignUp {
int big;
int medium;
int small;
String[]S;
public void parse(String input) {
 String regex="\\D+";
 String parse[]=input.split(regex);
 S=new String[parse.length];
 for(int i=0;i<parse.length;i++) {
  if(parse[i]!=null)
  this.S[i]=parse[i];
 }
}
SchoolSystem (Integer big, Integer medium, Integer small){
 this.big=big;
 this.medium=medium;
 this.small=small;
}
public void print() {
 String str="[";
 String a="\\d{2}";
 String b="\\d{1}";
 for(int i=0;i<S.length;i++) {
  if(S[i]!=null) {
   if(S[i].matches(a)==true) {
   str +="null, ";
   }
   if(S[i].matches(b)==true) {
    int x;
    x=Integer.parseInt(S[i]);
    if(this.addStudent(x)==true)
     str +="true, ";
    else 
     str +="false, ";
   }
  }
 }
 System.out.println(str+"]");
}
public boolean addStudent(int stuType) {
 if(stuType==1) {
  if(this.big>0) {
   this.big-=1;
   return true;
  }else
   return false;
 }
 if(stuType==2) {
  if(this.medium>0) {
   this.medium-=1;
   return true;
  }else
   return false;
 }
 if(stuType==3) {
  if(this.small>0) {
   this.small-=1;
   return true;
  }else
   return false;
 }
 return false;
}
public static void main(String[] args) throws Exception {
  SchoolSystem schoolSystem = new SchoolSystem (1,1,0);
  	schoolSystem.parse("addstudent[1],addstudent[2],addstudent[3],addstudent[1]");
  	schoolSystem.print();
        
}
}
