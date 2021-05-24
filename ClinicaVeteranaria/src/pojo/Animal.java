package pojo;


public class Animal{

    public static Animal getAnimalById(int idLivro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	private String nomea;
	private String idani;
	private String especie;
	private Cliente dono;
	
	public Animal(String idani, String nome, String especie, Cliente dono) {
		this.idani = idani;
		this.nomea = nome;
		this.especie = especie;
		this.dono = dono;
	}

    public Animal(String nome, String idani, String especie, String dono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Animal(String idani, String string, String string0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
                        public String getnomea(){
                            return nomea;
                        }
                        public void setnomea(String nomea){
                            this.nomea = nomea;
                        }
                        public String getidani(){
                            return idani;
                        }
                        public void set(String idani){
                            this.idani = idani;
                        }
                        public String getespecie(){
                            return especie;
                        }
                        public void setespecie(String especie){
                            this.especie = especie;
                        }
                        public Cliente getdono(){
                            return dono;
                        }
                        public void setdono(Cliente dono){
                            this.dono = dono;
                        }
        
        @Override
        public String toString() {
		return "[" + this.idani + ":"+ this.nomea + ":" + this.especie + "]";
	}

    public String getidono() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(Animal animal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}  
        
