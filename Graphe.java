import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Graphe{
    int nbSommets;
    int nbConnexions;
    List<Sommet> listSommets;

    public Graphe(){
        int max = 20;
        int min = 3;
        int max_rand;
        int min_rand;
        int s1;
        int s2;

        listSommets = new ArrayList<Sommet>();

        nbSommets = ThreadLocalRandom.current().nextInt(min, max);
        // System.out.println("Sommets: " + nbSommets);

        for(int i = 0; i < nbSommets; i++){
            listSommets.add(new Sommet());
        }

        max_rand = 3 * max;
        min_rand = 2 * min;
        nbConnexions = ThreadLocalRandom.current().nextInt(min, max);
        // System.out.println("Connexions: " + nbConnexions);

        for(int i = 0; i < nbConnexions; i++){
            s1 = ThreadLocalRandom.current().nextInt(0, nbSommets);
            s2 = ThreadLocalRandom.current().nextInt(0, nbSommets);
            // System.out.println("Connecte " + s1 + " à " + s2);
            listSommets.get(s1).connect(listSommets.get(s2));
        }
    }

    public void show(){
        for(int i = 0; i < nbSommets; i++){
            listSommets.get(i).showConnexions();
        }
    }

    public void reset(){
        for(Sommet tmp : listSommets){
            tmp.reset();
        }
    }

    public List<Sommet> DFS(List<Sommet> dfs, Sommet s){
        s.mark();
        // System.out.println(s.getID());
        dfs.add(s);
        for(Sommet tmp : s.getSuccesseurs()){
            if(!tmp.getMark()){
                DFS(dfs, tmp);
            }
        }
        return dfs;
    }

    public List<Sommet> DFSCycle(List<Sommet> dfs, Sommet s){
        s.mark();
        // System.out.println(s.getID());
        dfs.add(s);
        for(Sommet tmp : s.getSuccesseurs()){
            if(tmp.getMark()){
                dfs.add(tmp);
                return dfs;
            }
            else{
                DFS(dfs, tmp);
            }
        }
        return dfs;
    }

    public boolean Connexe(){
        List<Sommet> dfs = new ArrayList<Sommet>();
        dfs = this.DFS(dfs, this.getSommet(0));
        if(dfs.size() == nbSommets){
            for(Sommet tmp : dfs){
                System.out.print(tmp.getID() + "->");
            }
            System.out.println();
            // System.out.println("Le graphe est connexe");
            return true;
        }
        return false;
    }

    public boolean Cyclique(){
        List<Sommet> tmp = new ArrayList<Sommet>();
        boolean cycle = false;
        int size;
        int i;
        int j;

        tmp = this.DFSCycle(tmp, this.getSommet(0));
        size = tmp.size();

        for(i = 0; i < size; i++){
            for(j = i+1; j < size; j++){
                if(tmp.get(j) == tmp.get(i)){
                    cycle = true;
                    for(int k = i; k < j+1; k++){
                        System.out.print(tmp.get(k).getID() + "->");
                    }
                    break;
                }
            }
            if(cycle) break;
        }

        System.out.println();

        if(cycle){
            // System.out.println("Le graphe est cyclique");
            return true;
        }
        return false;
    }

    public Sommet getSommet(int ind){
        try {
            return listSommets.get(ind);
        } catch (Exception e) {
            System.out.println("Index invalide");
            return new Sommet();
        }
    }
}