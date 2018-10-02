import java.util.HashMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RegistroVoli {
	
	private HashMap<String, Volo> voli;

	public RegistroVoli() {
		this.voli = new HashMap<String, Volo>();
	}
	
	public Volo getVolo(String codice) {
		if(voli.get(codice)==null)
			return null;
		else
			return voli.get(codice);
	}
	
	public void aggiungiVolo(String codice, Volo volo) throws CodiceVoloNonValidoException {
		if(codice.length()!=5)
			throw new CodiceVoloNonValidoException();
		voli.put(codice, volo);
	}
	
	public void aggiungiVolo(String codice, String AreoportoPartenza, String aeroportoDestinazione, int durata) throws VoloNonValidoException, CodiceVoloNonValidoException {
		VoloDiretto nuovo=new VoloDiretto(AreoportoPartenza, aeroportoDestinazione, durata);
		this.aggiungiVolo(codice, (Volo)nuovo);
	}
	public String[] getListaCodiciDeiVoli() {
		String[] str= new String[voli.size()];
		int o=0;
		for(String i: voli.keySet())
			str[o++]=i;
		return str;
	}
	

	public void dumpSuFile(String nomeFile) throws IOException {
		PrintWriter uscita = null;
		try {
			FileOutputStream file = new FileOutputStream(nomeFile);
			uscita = new PrintWriter(file);
			Iterator<Entry<String, Volo>> i = voli.entrySet().iterator();
			while(i.hasNext()) {
				Entry<String, Volo> o=i.next();
				uscita.println(o.getKey()+" "+o.getValue());
			}

		} finally {
			if (uscita != null)
				uscita.close();
		}

	}
	
}