

package pojo;


public class Venda{
	private String nomea;
	private String idCli;
	private String idSer;
	private int venID;
	
	public Venda(String idCli, String nomea, String idSer) {
	//Super Construtor;	
                                     //      super();
                                           this.idCli = idCli;
		this.nomea = nomea;
		this.idSer = idSer;
	}
           public String getnomea(){
               return nomea;
           }
           
           public void setnomea(String nomea){
               this.nomea = nomea;
           }
           
           public String getidCli(){
                return idCli;
            }
           
           public void setidCli(String idCli){
                 this.idCli = idCli;
            }
           
           public String getidSer(){
                return idSer;
            }
           
           public void setidSer(){
                this.idSer = idSer;
            }
           public int getvenID(){
                return venID;
           }
           public void setvenID( int venID){
               this.venID = venID;
           }  
            

	public String toString() {
		return "[" + venID + " " + idCli + " " + nomea + " " + idSer + "] ";	
	}   

}

