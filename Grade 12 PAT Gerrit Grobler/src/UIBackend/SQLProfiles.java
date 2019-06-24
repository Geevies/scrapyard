
package UIBackend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLProfiles {
    
    public static void getProfiles() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Profiles.accdb");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Profiles");
            while (rs.next()) {
                System.out.println(rs.getString(2) + "\t\t" + rs.getInt(3) + "\t"
                                   + rs.getString(4) + "\t" + rs.getString(5));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Exception! Huge Error!");
            ex.printStackTrace();
        }
        
    }
    
    public static String[] getNew() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Profiles.accdb");
            Statement s = conn.createStatement();
            ResultSet amountReader = s.executeQuery("SELECT * FROM Profiles");
            int profileAmount = 0;
            while (amountReader.next()) {
                profileAmount++;
            }
            amountReader.close();
            String[] names = new String[profileAmount];
            ResultSet rs = s.executeQuery("SELECT * FROM Profiles WHERE ID > " + profileAmount);
            int i = 0;
            while (rs.next()) {
                names[i] = rs.getString(2);
                i++;
            }
            rs.close();
            return names;
        } catch (SQLException ex) {
            System.out.println("Exception! Huge Error!");
            ex.printStackTrace();
        }
        return null;
    }
    
    public static String[] getNames() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Profiles.accdb");
            Statement s = conn.createStatement();
            ResultSet amountReader = s.executeQuery("SELECT * FROM Profiles");
            int profileAmount = 0;
            while (amountReader.next()) {
                profileAmount++;
            }
            amountReader.close();
            String[] names = new String[profileAmount + 1];
            ResultSet rs = s.executeQuery("SELECT * FROM Profiles");
            int i = 0;
            while (rs.next()) {
                names[i] = rs.getString(2);
                i++;
            }
            rs.close();
            names[profileAmount] = "-Add Profile-";
            return names;
        } catch (SQLException ex) {
            System.out.println("Exception! Huge Error!");
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void newProfile(String prof, int score, String tank, String bkg) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Profiles.accdb");
            try (PreparedStatement stmnt = conn.prepareStatement("INSERT into Profiles(PName, Score, Tank, BackgroundScheme) VALUES (?, ?, ?, ?)")){
                stmnt.setString(1, prof);
                stmnt.setInt(2, score);
                stmnt.setString(3, tank);
                stmnt.setString(4, bkg);
                stmnt.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println("Error with inserting info");
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            System.out.println("Driver fail!");
            ex.printStackTrace();
        }
    }
    
    public static void deleteProfile(String prof) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Profiles.accdb");
            try (PreparedStatement stmnt = conn.prepareStatement("DELETE FROM Profiles WHERE Profiles.PName = '" + prof + "';")) {
                stmnt.executeUpdate();
            }
            catch (SQLException ex) {
                System.out.println("Error with deleting info");
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            System.out.println("Driver fail!");
            ex.printStackTrace();
        }
    }
    
    public static String pScore() {
        StringBuilder pScores = new StringBuilder("");
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Profiles.accdb");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT PName, Score FROM Profiles");
            while (rs.next()) {
                pScores.append(rs.getString(1)).append(" : ").append(rs.getInt(2)).append("\n");
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Exception! Huge Error!");
            ex.printStackTrace();
        }

        return pScores.toString();
    }
   
}
