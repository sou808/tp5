package tp5poo;

public class plante {
    protected String nom;
    protected int hauteur; 
    protected int age;      
    protected double prix;  
    private static final double AbsorMoyenne = 0; 

    public plante(String nom, int hauteur, int age, double prix) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.age = age;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return ("La plante du nom " + nom + " a une hauteur de " + hauteur + " cm, âgée de: " + age + " mois, son prix est: " + prix);
    }

    public void description() {
        System.out.println(toString());
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static class Fleur extends Plante {
        private String couleur;
        private int moisF;  

        public Fleur(String nom, int hauteur, int age, double prix, String couleur, int moisF) {
            super(nom, hauteur, age, prix);
            this.couleur = couleur;
            this.moisF = moisF;
        }

        public String getCouleur() {
            return couleur;
        }

        @Override
        public void description() {
            System.out.println(super.toString() + ", Couleur: " + couleur + ", Mois de floraison: " + moisF);
        }

        public void fleurir() {
            if (moisF == 4 || moisF == 5 || moisF == 6) {
                System.out.println(nom + " est en fleurs.");
            } else {
                System.out.println(nom + " n'est pas en fleurs.");
            }
        }
    }

    public static class Arbre extends Plante {
        private String type_Feuillage;
        private final double absorMoyenne = 22.0; 

        public Arbre(String nom, int hauteur, int age, double prix, String type_Feuillage) {
            super(nom, hauteur, age, prix);
            this.type_Feuillage = type_Feuillage;
        }

        
        public void description() {
            System.out.println(super.toString() + ", Type de Feuillage: " + type_Feuillage + ", Absorption moyenne de CO2: " + absorMoyenne);
        }

        public double absorptionCO2() {
            double absorption = absorMoyenne; 
            if (hauteur > 50) { 
                absorption += 3; 
            }
            return absorption; 
        }

        public boolean estCaduque() {
            return "Caduque".equals(type_Feuillage);
        }
    }

    public static class Pepiniere {
        private static final int MAX_PLANTES = 1000;
        private plante[] inventaire;
        private int nombreDePlantes;

        public Pepiniere() {
            inventaire = new plante[MAX_PLANTES];
            nombreDePlantes = 0;
        }

        public void ajoutPlante(plante plante) {
            if (nombreDePlantes < MAX_PLANTES) {
                inventaire[nombreDePlantes] = plante;
                nombreDePlantes++;
            } else {
                System.out.println("Impossible d'ajouter plus de plantes.");
            }
        }

        public void afficherInventaire() {
            System.out.println("Inventaire des plantes :");
          
                }
            
        
        public double totalAbsorptionTotaleCO2() {
            double total = 0;
            for (int i = 0; i < nombreDePlantes; i++) {
                total += inventaire[i].absorptionCO2();
            }
            return total;
        }

        public int compterArbresCaduques() {
            int count = 0;
            for (int i = 0; i < nombreDePlantes; i++) {
                if (inventaire[i] instanceof Arbre && ((Arbre) inventaire[i]).estCaduque()) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println("Pépinière GREEN HANDS");
        Pepiniere pepiniere = new Pepiniere();

       
        Fleur rose = new Fleur("Rose", 30, 12, 15.99, "Rouge", 2);
        Fleur tulipe = new Fleur("Tulipe", 20, 8, 12.99, "Jaune", 4);
        Arbre chene = new Arbre("Chêne", 200, 60, 89.99, "Caduque");
        Arbre sapin = new Arbre("Sapin", 150, 30, 59.99, "Persistant");

      
        pepiniere.ajoutPlante(rose);
        pepiniere.ajoutPlante(tulipe);
        pepiniere.ajoutPlante(chene);
        pepiniere.ajoutPlante(sapin);

      
        pepiniere.afficherInventaire();
        System.out.println("Total Absorption CO2: " + pepiniere.totalAbsorptionTotaleCO2() ;
        System.out.println("Nombre d'arbres caduques dans la pépinière : " + pepiniere.compterArbresCaduques());
    }
}

        	       
 
       
    
