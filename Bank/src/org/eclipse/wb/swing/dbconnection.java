package org.eclipse.wb.swing;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class dbconnection
{
	public Statement stmt;
	public Connection con;
	public ResultSet rs;
	public dbconnection(){
		
	   try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			stmt= con.createStatement();
		  }
	
	  catch(Exception e)
		  {
				System.out.println(e.getMessage());
		  }
	
	}
	
	public static void main(String [] args){
		new dbconnection();
	}
	
	public void insert(String name,String nominee,String add, String item1) {
		double balance=0.00;
		String query ="insert into bank (name,nominee,address,type,balance) values ('"+name+"' , '"+nominee+"' , '"+add+"','"+item1+"','"+balance+"' )" ;
		String query1="select max(acc_no) from bank";
		try{	
			stmt.executeQuery(query);
			JOptionPane.showMessageDialog(null, "Your Registration successfull");
			rs=stmt.executeQuery(query1);
			//System.out.println("try");
			while(rs.next()){
				int a=rs.getInt(1);
				JOptionPane.showMessageDialog(null, "Your Account no is:"+"0000"+a);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				if(rs!=null)
					rs.close();

				if(stmt!=null)
					stmt.close();

				if(con!=null)
					con.close();
			}
			catch(Exception ex){}
		}
	}
	public void login(String accno, String type, String amnt) {
		int a =Integer.parseInt(accno);
		int b =Integer.parseInt(amnt);
		String query3="UPDATE bank set balance =(("+b+")+(select bank.balance from bank  where bank.acc_no="+a+"))WHERE bank.acc_no="+a;
		String query4="UPDATE bank set balance =(("+-b+")+(select bank.balance from bank  where bank.acc_no="+a+"))WHERE bank.acc_no="+a;
		String query2="select balance from bank where acc_no="+a;
		try{	
			if(type.equals("Deposit")){
			stmt.executeQuery(query3);}
			else
			{
				stmt.executeQuery(query4);
			}
			stmt.executeQuery(query2);
			
			rs=stmt.executeQuery(query2);
			//System.out.println("try");
			
			while(rs.next()){
				int ab=rs.getInt(1);
				JOptionPane.showMessageDialog(null, "Your balance is:"+ab);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				if(rs!=null)
					rs.close();

				if(stmt!=null)
					stmt.close();

				if(con!=null)
					con.close();
			}
			catch(Exception ex){}
		}
	}
	
	
	
}