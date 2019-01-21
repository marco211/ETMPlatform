package it.unisa.etm.model.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import it.unisa.etm.model.bean.Utente;
import it.unisa.etm.model.database.DatabaseManager;
import it.unisa.etm.model.interfaces.UtenteModelInterface;
/**
 * Classe che implementa le funzionalita dedicate all'utente registrato.
 * @author ETM
 *
 */
public  class UtenteManager implements UtenteModelInterface{

<<<<<<< HEAD
  public UtenteManager() {

  }

  @Override
  public Utente getInfo(String email){

    Utente utente=null;

    try {
      Connection istance=DatabaseManager.getIstance();
      PreparedStatement pr=istance.prepareStatement("SELECT * FROM UTENTE WHERE EMAIL=?");
      pr.setString(1, email);
      ResultSet rs=pr.executeQuery();
      rs.next();
      if(rs.getString("TIPO").equals("s")){
        utente=new Utente();
        utente.setNome(rs.getString("NOME"));
        utente.setCognome(rs.getString("COGNOME"));
        utente.setMatricola(rs.getString("MATRICOLA"));
        utente.setTipo(rs.getString("TIPO"));
        if(rs.getInt("PROPOSTATESI_ID")!=0)
          utente.setPropostaTesi_Id(rs.getInt("PROPOSTATESI_ID"));
        utente.setEmail(rs.getString("EMAIL"));
        utente.setDataDiNascita(rs.getString("DATA_NASCITA"));
        utente.setPassword(rs.getString("PASSWORD"));
        utente.setValidazione(rs.getString("VALIDAZIONE"));
      }
      else if(rs.getString("TIPO").equals("d")) {
        utente=new Utente();
        utente.setNome(rs.getString("NOME"));
        utente.setCognome(rs.getString("COGNOME"));
        utente.setEmail(rs.getString("EMAIL"));
        utente.setTipo(rs.getString("TIPO"));
        utente.setDataDiNascita(rs.getString("DATA_NASCITA"));
        utente.setPassword(rs.getString("PASSWORD"));
        utente.setUfficio(rs.getString("UFFICIO"));
        utente.setValidazione(rs.getString("VALIDAZIONE"));
        PreparedStatement pr1=istance.prepareStatement("SELECT INSEGNAMENTO_NOME FROM INSEGNA WHERE UTENTE_EMAIL=?");
        pr1.setString(1, email);
        ResultSet rs1=pr1.executeQuery();
        while(rs1.next()) {
          utente.setInsegnamento(rs1.getString("INSEGNAMENTO_NOME"));
        }
      }
    }catch(SQLException e) {
      e.printStackTrace();
      return null;
    }

    return utente;
  }

  @Override
  public Utente cercaUtente(String email){

    Utente utente=null;
    try {
      Connection istance=DatabaseManager.getIstance();
      PreparedStatement pr=istance.prepareStatement("SELECT * FROM UTENTE WHERE EMAIL=?");
      pr.setString(1, email);
      ResultSet rs=pr.executeQuery();
      rs.next();
      if(rs.getString("TIPO").equals("s")){
        utente = new Utente();
        utente.setNome(rs.getString("NOME"));
        utente.setCognome(rs.getString("COGNOME"));
        utente.setMatricola(rs.getString("MATRICOLA"));
        utente.setTipo(rs.getString("TIPO"));
        if(rs.getInt("PROPOSTATESI_ID")!=0)
          utente.setPropostaTesi_Id(rs.getInt("PROPOSTATESI_ID"));
        utente.setEmail(rs.getString("EMAIL"));
        utente.setDataDiNascita(rs.getString("DATA_NASCITA"));
        utente.setPassword(rs.getString("PASSWORD"));
        utente.setValidazione(rs.getString("VALIDAZIONE"));
      }
      else if(rs.getString("TIPO").equals("d")) {
        utente = new Utente();
        utente.setNome(rs.getString("NOME"));
        utente.setCognome(rs.getString("COGNOME"));
        utente.setEmail(rs.getString("EMAIL"));
        utente.setTipo(rs.getString("TIPO"));
        utente.setDataDiNascita(rs.getString("DATA_NASCITA"));
        utente.setPassword(rs.getString("PASSWORD"));
        utente.setUfficio(rs.getString("UFFICIO"));
        utente.setValidazione(rs.getString("VALIDAZIONE"));
        PreparedStatement pr1=istance.prepareStatement("SELECT INSEGNAMENTO_NOME FROM INSEGNA WHERE UTENTE_EMAIL=?");
        pr1.setString(1, email);
        ResultSet rs1=pr1.executeQuery();
        while(rs1.next()) {
          utente.setInsegnamento(rs1.getString("INSEGNAMENTO_NOME"));
        }
      }
    }catch(SQLException e) {
      e.printStackTrace();
      return null;
    }
    return utente;
  }

  @Override
  public boolean modificaPassword(Utente utente) {
    try {
      Connection istance=DatabaseManager.getIstance();
      PreparedStatement ps=null;
      String insertSQL=null;
      insertSQL = "UPDATE utente SET password=? WHERE email=?;";
      ps=istance.prepareStatement(insertSQL);
      ps.setString(1, utente.getPassword());
      ps.setString(2, utente.getEmail());
      if (ps.executeUpdate() == 0) return false;
      return true;
    } catch(SQLException e) {
      return false;
    }
  }

  @Override
  public boolean modificaUtente(Utente utente){
    try {
      Connection istance=DatabaseManager.getIstance();
      PreparedStatement ps=null;
      String insertSQL=null;
      if(utente.getTipo().equals("s"))
      {
        insertSQL = "UPDATE utente SET nome=? , cognome=? , data_nascita=?, matricola=? WHERE email=?;";
        ps=istance.prepareStatement(insertSQL);
        ps.setString(1, utente.getNome());;
        ps.setString(2, utente.getCognome());
        ps.setString(3, utente.getDataDiNascita());
        ps.setString(4, utente.getMatricola());
        ps.setString(5,  utente.getEmail());



      }
      else if(utente.getTipo().equals("d"))
      {
        insertSQL = "UPDATE utente SET nome=? , cognome=? , data_nascita=? , ufficio=? WHERE email=?;";
        ps=istance.prepareStatement(insertSQL);
        ps.setString(1, utente.getNome());;
        ps.setString(2, utente.getCognome());
        ps.setString(3, utente.getDataDiNascita());
        ps.setString(4, utente.getUfficio());
        ps.setString(5, utente.getEmail());
        ps.executeUpdate();

      }else return false;
      if(ps.executeUpdate() == 0) return false;
      return true;
    }catch(SQLException e) {
      return false;
    }
  }

  @Override
  public ArrayList<Utente> cercaListaUtenteNome(String nome){
    Connection istance;
    try {
      istance = DatabaseManager.getIstance();
      PreparedStatement pr=istance.prepareStatement("SELECT * FROM UTENTE WHERE NOME=?");
      pr.setString(1, nome);
      ArrayList<Utente> list=new ArrayList<Utente>();
      ResultSet rs=pr.executeQuery();
      if(rs.next()) {
        do {
          Utente utente=new Utente();
          utente.setEmail(rs.getString("EMAIL"));
          utente.setCognome(rs.getString("COGNOME"));
          utente.setNome(rs.getString("NOME"));
          utente.setTipo(rs.getString("TIPO"));
          if(utente.getTipo().equals("s")) {
            utente.setMatricola(rs.getString("MATRICOLA"));
          }
          else {
            utente.setUfficio(rs.getString("UFFICIO"));
          }
          list.add(utente);
        }while(rs.next());

        return list;
      }else return null;

    } catch (SQLException e) {
      return null;
    }
  }

  @Override
  public ArrayList<Utente> cercaListaUtenteCognome(String cognome){
    Connection istance;
    try {
      istance = DatabaseManager.getIstance();
      PreparedStatement pr=istance.prepareStatement("SELECT * FROM UTENTE WHERE COGNOME=?");
      pr.setString(1, cognome);
      ArrayList<Utente> list=new ArrayList<Utente>();
      ResultSet rs=pr.executeQuery();
      if(rs.next()) {
        do {
          Utente utente=new Utente();
          utente.setEmail(rs.getString("EMAIL"));
          utente.setCognome(rs.getString("COGNOME"));
          utente.setNome(rs.getString("NOME"));
          utente.setTipo(rs.getString("TIPO"));
          if(utente.getTipo().equals("s")) {
            utente.setMatricola(rs.getString("MATRICOLA"));
          }
          else {
            utente.setUfficio(rs.getString("UFFICIO"));
          }
          list.add(utente);
        }while(rs.next());

        return list;
      }else return null;

    } catch (SQLException e) {
      return null;
    }
  }
=======
	public UtenteManager() {

	}

	@Override
	public Utente getInfo(String email){

		Utente utente=null;
		
		try {
			Connection istance=DatabaseManager.getIstance();
			PreparedStatement pr=istance.prepareStatement("SELECT * FROM UTENTE WHERE EMAIL=?");
			pr.setString(1, email);
			ResultSet rs=pr.executeQuery();
			rs.next();
			if(rs.getString("TIPO").equals("s")){
				utente=new Utente();
				utente.setNome(rs.getString("NOME"));
				utente.setCognome(rs.getString("COGNOME"));
				utente.setMatricola(rs.getString("MATRICOLA"));
				utente.setTipo(rs.getString("TIPO"));
				if(rs.getInt("PROPOSTATESI_ID")!=0)
					utente.setPropostaTesi_ID(rs.getInt("PROPOSTATESI_ID"));
				utente.setEmail(rs.getString("EMAIL"));
				utente.setDataDiNascita(rs.getString("DATA_NASCITA"));
				utente.setPassword(rs.getString("PASSWORD"));
				utente.setValidazione(rs.getString("VALIDAZIONE"));
			}
			else if(rs.getString("TIPO").equals("d")) {
				utente=new Utente();
				utente.setNome(rs.getString("NOME"));
				utente.setCognome(rs.getString("COGNOME"));
				utente.setEmail(rs.getString("EMAIL"));
				utente.setTipo(rs.getString("TIPO"));
				utente.setDataDiNascita(rs.getString("DATA_NASCITA"));
				utente.setPassword(rs.getString("PASSWORD"));
				utente.setUfficio(rs.getString("UFFICIO"));
				utente.setValidazione(rs.getString("VALIDAZIONE"));
				PreparedStatement pr1=istance.prepareStatement("SELECT INSEGNAMENTO_NOME FROM INSEGNA WHERE UTENTE_EMAIL=?");
				pr1.setString(1, email);
				ResultSet rs1=pr1.executeQuery();
				while(rs1.next()) {
					utente.setInsegnamento(rs1.getString("INSEGNAMENTO_NOME"));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}

		return utente;
	}

	@Override
	public Utente cercaUtente(String email){

		Utente utente=null;
		try {
		Connection istance=DatabaseManager.getIstance();
		PreparedStatement pr=istance.prepareStatement("SELECT * FROM UTENTE WHERE EMAIL=?");
		pr.setString(1, email);
		ResultSet rs=pr.executeQuery();
		rs.next();
		if(rs.getString("TIPO").equals("s")){
			utente = new Utente();
			utente.setNome(rs.getString("NOME"));
			utente.setCognome(rs.getString("COGNOME"));
			utente.setMatricola(rs.getString("MATRICOLA"));
			utente.setTipo(rs.getString("TIPO"));
			if(rs.getInt("PROPOSTATESI_ID")!=0)
				utente.setPropostaTesi_ID(rs.getInt("PROPOSTATESI_ID"));
			utente.setEmail(rs.getString("EMAIL"));
			utente.setDataDiNascita(rs.getString("DATA_NASCITA"));
			utente.setPassword(rs.getString("PASSWORD"));
			utente.setValidazione(rs.getString("VALIDAZIONE"));
		}
		else if(rs.getString("TIPO").equals("d")) {
			utente = new Utente();
			utente.setNome(rs.getString("NOME"));
			utente.setCognome(rs.getString("COGNOME"));
			utente.setEmail(rs.getString("EMAIL"));
			utente.setTipo(rs.getString("TIPO"));
			utente.setDataDiNascita(rs.getString("DATA_NASCITA"));
			utente.setPassword(rs.getString("PASSWORD"));
			utente.setUfficio(rs.getString("UFFICIO"));
			utente.setValidazione(rs.getString("VALIDAZIONE"));
			PreparedStatement pr1=istance.prepareStatement("SELECT INSEGNAMENTO_NOME FROM INSEGNA WHERE UTENTE_EMAIL=?");
			pr1.setString(1, email);
			ResultSet rs1=pr1.executeQuery();
			while(rs1.next()) {
				utente.setInsegnamento(rs1.getString("INSEGNAMENTO_NOME"));
			}
		}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return utente;
	}

	@Override
	public boolean modificaPassword(Utente utente) {
		try {
			Connection istance=DatabaseManager.getIstance();
			PreparedStatement ps=null;
			String insertSQL=null;
			insertSQL = "UPDATE utente SET password=? WHERE email=?;";
			ps=istance.prepareStatement(insertSQL);
			ps.setString(1, utente.getPassword());
			ps.setString(2, utente.getEmail());
			if (ps.executeUpdate() == 0) {
				return false;
			}
			return true;
		} catch(SQLException e) {
			return false;
		}
	}

	@Override
	public boolean modificaUtente(Utente utente){
		try {
			Connection istance=DatabaseManager.getIstance();
			PreparedStatement ps=null;
			String insertSQL=null;
			if(utente.getTipo().equals("s"))
			{
				insertSQL = "UPDATE utente SET nome=? , cognome=? , data_nascita=?, matricola=? WHERE email=?;";
				ps=istance.prepareStatement(insertSQL);
				ps.setString(1, utente.getNome());;
				ps.setString(2, utente.getCognome());
				ps.setString(3, utente.getDataDiNascita());
				ps.setString(4, utente.getMatricola());
				ps.setString(5,  utente.getEmail());
				
				
				
			}
			else if(utente.getTipo().equals("d"))
			{
				insertSQL = "UPDATE utente SET nome=? , cognome=? , data_nascita=? , ufficio=? WHERE email=?;";
				ps=istance.prepareStatement(insertSQL);
				ps.setString(1, utente.getNome());;
				ps.setString(2, utente.getCognome());
				ps.setString(3, utente.getDataDiNascita());
				ps.setString(4, utente.getUfficio());
				ps.setString(5, utente.getEmail());
				ps.executeUpdate();
				
			}else return false;
			if(ps.executeUpdate() == 0) return false;
			return true;
		}catch(SQLException e) {
			return false;
		}
	}

	@Override
	public ArrayList<Utente> cercaListaUtenteNome(String nome){
		Connection istance;
		try {
			istance = DatabaseManager.getIstance();
			PreparedStatement pr=istance.prepareStatement("SELECT * FROM UTENTE WHERE NOME=?");
			pr.setString(1, nome);
			ArrayList<Utente> list=new ArrayList<Utente>();
			ResultSet rs=pr.executeQuery();
			if(rs.next()) {
				do {
					Utente utente=new Utente();
					utente.setEmail(rs.getString("EMAIL"));
					utente.setCognome(rs.getString("COGNOME"));
					utente.setNome(rs.getString("NOME"));
					utente.setTipo(rs.getString("TIPO"));
					if(utente.getTipo().equals("s")) {
						utente.setMatricola(rs.getString("MATRICOLA"));
					}
					else {
						utente.setUfficio(rs.getString("UFFICIO"));
					}
					list.add(utente);
				}while(rs.next());
				
				return list;
			}else return null;
			
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public ArrayList<Utente> cercaListaUtenteCognome(String cognome){
		Connection istance;
		try {
			istance = DatabaseManager.getIstance();
			PreparedStatement pr=istance.prepareStatement("SELECT * FROM UTENTE WHERE COGNOME=?");
			pr.setString(1, cognome);
			ArrayList<Utente> list=new ArrayList<Utente>();
			ResultSet rs=pr.executeQuery();
			if(rs.next()) {
				do {
					Utente utente=new Utente();
					utente.setEmail(rs.getString("EMAIL"));
					utente.setCognome(rs.getString("COGNOME"));
					utente.setNome(rs.getString("NOME"));
					utente.setTipo(rs.getString("TIPO"));
					if(utente.getTipo().equals("s")) {
						utente.setMatricola(rs.getString("MATRICOLA"));
					}
					else {
						utente.setUfficio(rs.getString("UFFICIO"));
					}
					list.add(utente);
				}while(rs.next());
				
				return list;
			}else return null;
		
		} catch (SQLException e) {
			return null;
		}
	}
>>>>>>> f8b4962801703e0672590ba961de03eb5dca67f8

}
