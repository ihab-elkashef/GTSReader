package ihm;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bdd.Database;


public class ListerRessources {

	// Lister les fichiers *.gts pr�sents dans le r�pertoire /res
	
	public ListerRessources() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Scan le r�pertoire contenant les fichiers *.gts . 
	 * @return Tableau contenant la liste des fichiers trouv�s dans le r�pertoire *.gts .
	 */
	public String[] genererTabGts(){
		try {
			List<String> gtsFiles = new ArrayList<String>();
			
			Database db = new Database();
			db.connect();
			ResultSet rs = db.getResultOf("Select * from gts;");
			
			while(rs.next()){
				gtsFiles.add(rs.getString(1));
				System.out.println(rs.getString(1));
			}

			db.disconnect();
			
			String[] gtsFilesTab = new String[gtsFiles.size()];
			for(int i=0 ; i<gtsFilesTab.length ; i++){
				gtsFilesTab[i] = gtsFiles.get(i);
			}
			return gtsFilesTab;
		} catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
}
 
