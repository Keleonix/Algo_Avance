import java.util.*;

public class Sommet{
  static int ID;
  int id;
  boolean marked;
  List<Sommet> successeurs;

  public Sommet(){
    id = ID++;
    marked = false;
    successeurs = new ArrayList<Sommet>();
  }

  private boolean alreadyConnected(Sommet s){
    for(Sommet tmp : successeurs){
      if(tmp == s){
        return true;
      }
    }
    return false;
  }

  public boolean hasSuccessors(){
    if(successeurs.size() != 0) return true;
    return false;
  }

  public boolean hasUnmarkedSuccessor(){
    if(!hasSuccessors()) return false;
    for(Sommet tmp : successeurs){
      if(tmp.getMark() == false) return true;
    }
    return false;
  }

  public Sommet firstUnmarkedSuccessor(){
    for(Sommet tmp : successeurs){
      if(!tmp.getMark()) return tmp;
    }
    return new Sommet();
  }

  public void connect(Sommet s){
    if(!alreadyConnected(s) && s != this){
      successeurs.add(s);
      s.getSuccesseurs().add(this);
    }
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

  public void showConnexions(){
    System.out.println("Sommet " + id + " est connecté à :");
    for(Sommet tmp : successeurs){
      System.out.println(tmp.getID());
    }
  }

  public void mark(){
    marked = true;
  }

  public void reset(){
    marked = false;
  }

  public int getID(){
    return id;
  }

  public List<Sommet> getSuccesseurs(){
    return successeurs;
  }

  public boolean getMark(){
    return marked;
  }
}

