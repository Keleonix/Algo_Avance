import java.util.*;

public class Sommet{
  static int ID;
  int id;
  List<Sommet> successeurs = new ArrayList<Sommet>();

  public Sommet(){
    id = ID++;
  }

  public void connect(Sommet s){
    successeurs.add(s);
    return;
  }

  public void deconnecte(Sommet s){
    for(Sommet tmp : successeurs){
      if(tmp == s){
        successeurs.remove(tmp);
        return;
      }
    }
    System.out.println("Erreur, le sommet a déconnecter n'existe pas");
  }
}

/*public class Arrete{

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
}*/
