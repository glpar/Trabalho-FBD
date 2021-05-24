

package pojo;


public class Serviço {

    public static void add(Serviço aloc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	private  String idSer;
	private int valor;
	
	
	public Serviço(String idSer,int valor) {
		this.idSer = idSer;
		this.valor = valor;
	}

    public Serviço(int valor, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Serviço(int valor, String string, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	public String getidSer() {
		return this.idSer;
	}
	public float getvalor() {
		return this.valor;
	}
	public String toString() {
		return "[" + idSer + " " + valor + "] ";
	}
}