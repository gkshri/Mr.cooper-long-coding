import java.io.*;
import java.sql.Timestamp;
import java.util.*;

class user{
    int userid;
    float height;
    float weight;
    float bmi;

    public user(int userid,float height,float weight){
        this.userid=userid;
        this.height=height;
        this.weight=weight;
        this.calcBMI();
    }
    public float getheight(){
        return this.height;
    }
    public void setheight(float h){
        this.height=h;
    }
    public float getWeight(){
        return this.weight;
    }
    public void setWeight(float w){
        this.weight=w;
    }
    public void calcBMI(){
        this.bmi= this.weight/(this.height*this.height);
    }
    public int getUserID(){
        return this.userid;
    }
    public void setUserid(int i){
        this.userid=i;
    }
}
class UserDetails{
    int userid;
    String username;
    String email;
    String password;
    List<Integer> friends;

    public UserDetails(int userid, String username, String email, String password, List<Integer> friends) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.friends = friends;
    }
    public void setUserid(int i){
        this.userid=i;
    }
    public int getUserID(){
        return this.userid;
    }
    public void addfriends(int fid){
        this.friends.add(fid);
    }
    public List getfriends(){
        return this.friends;
    }
    public void setPass(String pass){
        this.password=pass;
    }
    public String getpass(){
        return this.password;
    }
}
class Activity{
    static Map<String,Float>activity;
    public Activity(){
        //System.out.println("input activity and avg calories burnt per min");
        activity= new HashMap<>();
        activity.put("running",(float)10);
        activity.put("yoga",(float)15);
        activity.put("swimming", (float)20);
        //Scanner sc=new Scanner(System.in);
        //while(sc.hasNext()){
            //String a=sc.nextLine();
            //float cal=sc.nextFloat();
            //activity.put(a, cal);
        //}
        //sc.close();
    }
    public static float findcalories(String s){
        for(String act:activity.keySet()){
            if(act.equals(s)){
                return activity.get(act);
            }
        }
        return 0;
    }

}
class daily{
    int userid;
    int cburnperday;
    
}
class ActivityDonebyUser{
    int userid;
    Map<String,Timestamp> activitydone;
    Timestamp time;
    float caloriesBurnt;
    
    public void setuserid(int i){
        this.userid=i;
    }
    public int getUserID(){
        return this.userid;
    }
    public void addActivity(String activity){
        this.activitydone.add(activity);
        this.time=new Timestamp(System.currentTimeMillis());
    }
    public void calcBurnt(){
        for(String s: activitydone){
            caloriesBurnt+=Activity.findcalories(s);
        }
    } 
}

class runnable{
    public static void main(String[] args) {
        System.out.println("Activity Tracker");
        Activity act=new Activity();
        Scanner sc=new Scanner(System.in);
        while(true){
            int userid=1;
            
            Map<Integer,UserDetails> u=new HashMap<>(); //u(userid,userDetails)
            Map<UserDetails,user> d=new HashMap<>();
            Map<Integer,ActivityDonebyUser> actdone=new HashMap<>(); // actdone(userid,Activity Done by user) 
           
        
            System.out.println("1.create User 2.add user details 3.activities done");
            int n=sc.nextInt();
            if(n==1){
                System.out.println("enter user details");
                String username=sc.next();
                String email=sc.next();
                String password=sc.next();
                List<Integer> friends=new ArrayList<>();
                UserDetails newUser = new UserDetails(userid,username,email,password,friends);
                u.put(userid, newUser);
                System.out.println("enter user height weight");
                int h=sc.nextInt();
                int w=sc.nextInt();
                user data=new user(userid,h,w);
                d.put(newUser,data);
                actdone.put(userid, new ActivityDonebyUser());
                userid++;
            }
            if(n==2){
                System.out.println("enter user no");
                int uno=sc.nextInt();
                int flag=0;
                for(Integer i:u.keySet()){
                    if(i==uno){
                        flag=1;
                        System.out.println("enter height and weight");
                            int h=sc.nextInt();
                            int w=sc.nextInt();
                            user data=d.get(i);
                            data.setheight(h);
                            data.setWeight(w);
                        
                    }
                }
                if(flag==0){
                    System.out.println("user Id does'nt exist");
                }
            }
            if(n==3){
                System.out.println("activities done");
                System.out.println("enter userid");
                int i=sc.nextInt();
                for(Integer j:actdone.keySet()){
                    if(j==i){
                        ActivityDonebyUser done=actdone.get(i);
                        String activity=sc.nextLine();
                        done.addActivity(activity);

                    }
                }
                
            }
        }
    }
}

void returnactivity(int userid){
    
        if(actdone.contains(userid)){
            ActivityDonebyUser done=actdone.get(userid);


        }
    }
}





