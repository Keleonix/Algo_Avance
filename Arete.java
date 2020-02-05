public class Arete{

  static int ID;
  int id;
  Sommet deb;
  Sommet fin;
  int valeur;

  public Arrete(int val){
    id = ID++;
    valeur = val;
  }

  public void setSommets(Sommet d, Sommet f){
    deb = d;
    fin = f;
  }

  public void setDeb(Sommet d){
    deb = d;
  }

  public void setFin(Sommet f){
    fin = f;
  }

  public int getValeur(){
    return valeur;
  }

  public Sommet getDeb(){
    return deb;
  }

  public Sommet getFin(){
    return fin;
  }

  public int getId(){
    return id;
  }
}