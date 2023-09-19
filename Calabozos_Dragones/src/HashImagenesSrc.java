import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class HashImagenesSrc {
	
	private Hashtable<String, List<String>> hashtable = new Hashtable<>();
	
	public HashImagenesSrc() {		
		//Base de ruta
		String src = "src/SPRITES/PROFESORES Y ESBIRROS/";
		//rutas de png
        List<String> algebraSrc = new ArrayList<String>();
        algebraSrc.add(src + "Algebra/matriz ESBIRROS.png");
        algebraSrc.add(src + "Algebra/Algebra PROFESOR.png");
        List<String> analisisSrc = new ArrayList<String>();
        analisisSrc.add(src + "Analisis/integrales ESBIRROS.png");
        analisisSrc.add(src + "Analisis/Ochoa.png");
        List<String> geometriaSrc = new ArrayList<String>();
        geometriaSrc.add(src + "Geometria/Cónica ESBIRROS.png");
        geometriaSrc.add(src + "Geometria/PROFESOR_GENÉRICO.png");
        List<String> algoritmosSrc = new ArrayList<String>();
        algoritmosSrc.add(src + "Algoritmos/PYTHON_ESBIRROS.png");
        algoritmosSrc.add(src + "Algoritmos/Gorra.png");
        List<String> paradigmasSrc = new ArrayList<String>();
        paradigmasSrc.add(src + "Paradigmas/Bauti ESBIRRO.png");
        paradigmasSrc.add(src + "Paradigmas/Pablo Vidal Base.png");
        List<String> inteligenciaartificalSrc = new ArrayList<String>();
        inteligenciaartificalSrc.add(src + "Inteligencia Artificial/inteligencia ESBIRROS.png");
        inteligenciaartificalSrc.add(src + "Inteligencia Artificial/harpo.png");
        List<String> compiladoresSrc = new ArrayList<String>();
        compiladoresSrc.add(src + "Compiladores/bug ESBIRROS.png");
        compiladoresSrc.add(src + "Compiladores/PROFESOR GENÉRICO.png");
        List<String> tesisSrc = new ArrayList<String>();
        tesisSrc.add(src + "");
        tesisSrc.add(src + "Tesis/PROFESOR.png");
        List<String> pasantiasSrc = new ArrayList<String>();
        pasantiasSrc.add(src + "Pasantias/Pala.png");
        pasantiasSrc.add(src + "Pasantias/image (1).png");
        
        //Insertamos al hash
        hashtable.put("Algebra", algebraSrc);
        hashtable.put("Analisis", analisisSrc);
        hashtable.put("Geometria", geometriaSrc);
        hashtable.put("Algoritmos", algoritmosSrc);
        hashtable.put("Paradigmas", paradigmasSrc);
        hashtable.put("InteligenciaArtificial", inteligenciaartificalSrc);
        hashtable.put("Compiladores", compiladoresSrc);
        hashtable.put("Tesis", tesisSrc);
        hashtable.put("Pasantias", pasantiasSrc);
        
        
        
        //Heroes
        List<String> heroes = new ArrayList<String>();
        src = "src/SPRITES/HEROES/";
        heroes.add(src+"CABALLERO.png");
        heroes.add(src+"ARQUERO.png");
        heroes.add(src+"MAGO FUEGO.png");
        hashtable.put("Heroes", heroes);
        
    }
	
    public List<String> get(String key) {
        return hashtable.get(key);
    }
}
