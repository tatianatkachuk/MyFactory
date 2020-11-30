import java.util.HashMap;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

public class Manager {

    final static Logger log = Logger.getLogger(Manager.class.getName());

    private static Manager instance; //crear instancia

    HashMap<String, ResourceBundle> data;

    private Manager(){
        this.data= new HashMap<String, ResourceBundle>();
    }

    public static Manager getInstance(){//unica instancia
        if(instance==null){
            log.info("Se crea una unica instancia");
            instance=new Manager();
        }
        return instance;
    }

    public String getText(String idioma, String id){
        log.info("idioma: " + idioma + " id: " + id);
        String result=null;

        ResourceBundle res = this.data.get(idioma);
        //resposta NO
        if(res==null){
            log.info( idioma + " no existe");
            res=ResourceBundle.getBundle(idioma);
            this.data.put(idioma, res);
            log.info("se añade el idioma al diccionario");
        }
        else log.warn(idioma + " sí que existe");
        result=res.getString(id);
        log.info(""+ result);
        return result;
    }


    public static void main(String[] args) {
        String f1=Manager.getInstance().getText("en","frase1");
        String f2=Manager.getInstance().getText("es","frase2");
        String f3=Manager.getInstance().getText("en","frase3");
        String f4=Manager.getInstance().getText("nk","frase4");
        log.info(f1);
        log.info(f2);
        log.info(f3);
        log.info(f4);
    }
}
