package bdd;

public class TableMaker {

	public TableMaker() {
		// TODO Auto-generated method stub
		Database db = new Database();
		db.connect();
		db.updateValue("Drop table gts;");
		db.updateValue("Create table gts(path text, tags text);");
		db.updateValue("Insert into gts values('/gts/bunny.gts', null)");
		db.updateValue("Insert into gts values('/gts/cone.gts', null)");
		db.updateValue("Insert into gts values('/gts/cube.gts', null)");
		db.updateValue("Insert into gts values('/gts/epcot.gts', null)");
		db.updateValue("Insert into gts values('/gts/goblet.gts', null)");
		db.updateValue("Insert into gts values('/gts/head.gts', null)");
		db.updateValue("Insert into gts values('/gts/helix2.gts', null)");
		db.updateValue("Insert into gts values('/gts/horse.gts', null)");
		db.updateValue("Insert into gts values('/gts/icosa.gts', null)");
		db.updateValue("Insert into gts values('/gts/seashell.gts', null)");
		db.updateValue("Insert into gts values('/gts/space_shuttle.gts', null)");
		db.updateValue("Insert into gts values('/gts/space_station.gts', null)");
		db.updateValue("Insert into gts values('/gts/sphere20.gts', null)");
		db.updateValue("Insert into gts values('/gts/sphere5.gts', null)");
		db.updateValue("Insert into gts values('/gts/tetrahedon.gts', null)");
		db.updateValue("Insert into gts values('/gts/tie.gts', null)");
		db.updateValue("Insert into gts values('/gts/x_wing.gts', null)");
		db.disconnect();
	}

}
