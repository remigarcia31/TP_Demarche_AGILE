/*
 *
 */
package tp04.metier;

import java.util.ArrayList;
import java.util.Objects;

/**
 * <p>
 * Descriptions de la classe portefeuille<p>
 * <p>
 * La classe Portefeuille contient des informations sur les actions détenues,
 * les transactions effectuées. et les ordres en attente pour un investisseur
 * donné.</p>
 *
 * @author M2 IDA 2024
 * @licence Apache 2.0
 */
public class Portefeuille {

    /**
     * Identifiant unique du portefeuille.
     */
    private Integer id = null;

    /**
     * Nom du propriétaire du portefeuille.
     */
    private String nomProprietaire = new String();

    /**
     * Solde actuel du portefeuille.
     */
    private double solde = 0.0;

    /**
     * Liste des actions détenues dans le portefeuille.
     */
    private ArrayList<Action> listeAction = new ArrayList<>();

    /**
     * Liste des transactions effectuées dans le portefeuille.
     */
    private ArrayList<Transaction> listeTransaction = new ArrayList<>();

    /**
     * Liste des ordres en attente dans le portefeuille.
     */
    private ArrayList<Ordre> listeOrdre = new ArrayList<>();

    /**
     * Constructeur par défaut de la classe Portefeuille.
     */
    public Portefeuille() {
    }

    /**
     * Constructeur avec l'initialisation de l'identifiant et du solde du
     * portefeuille.
     *
     * @param designationProprietaire Nom du propriétaire.
     * @param montant Solde initial du portefeuille.
     */
    public Portefeuille(final double montant,
            final String designationProprietaire) {
        this.nomProprietaire = designationProprietaire;
        this.id = this.nomProprietaire.hashCode();
        this.solde = montant;
    }

    /**
     * Définit l'identifiant du portefeuille.
     *
     * @param id Identifiant unique du portefeuille.
     */
    public void definirId(Integer id) {
        this.id = id;
    }

    /**
     * Définit le nom du propriétaire du portefeuille.
     *
     * @param nomProprietaire Nom du propriétaire du portefeuille.
     */
    public void definirNomProprietaire(String nomProprietaire) {
        this.nomProprietaire = nomProprietaire;
    }

    /**
     * Définit le solde du portefeuille.
     *
     * @param solde Solde du portefeuille.
     */
    public void definirSolde(double solde) {
        this.solde = solde;
    }

    /**
     * Ajoute une action à la liste des actions détenues dans le portefeuille.
     *
     * @param action Action à ajouter.
     */
    public void ajouterAction(Action action) {
        this.listeAction.add(action);
    }

    /**
     * Ajoute une transaction à la liste des transactions effectuées dans le
     * portefeuille.
     *
     * @param transaction Transaction à ajouter.
     */
    public void ajouterTransaction(Transaction transaction) {
        this.listeTransaction.add(transaction);
    }

    /**
     * Ajoute un ordre à la liste des ordres en attente dans le portefeuille.
     *
     * @param ordre Ordre à ajouter.
     */
    public void ajouterOrdre(Ordre ordre) {
        this.listeOrdre.add(ordre);
    }

    /**
     * Obtient l'identifiant du portefeuille.
     *
     * @return Identifiant unique du portefeuille.
     */
    public Integer obtenirId() {
        return this.id;
    }

    /**
     * Obtient le nom du propriétaire du portefeuille.
     *
     * @return Nom du propriétaire du portefeuille.
     */
    public String obtenirNomProprietaire() {
        return nomProprietaire;
    }

    /**
     * Obtient le solde du portefeuille.
     *
     * @return Solde actuel du portefeuille.
     */
    public double obtenirSolde() {
        return this.solde;
    }

    /**
     * Obtient la liste des actions détenues dans le portefeuille.
     *
     * @return Liste des actions détenues.
     */
    public ArrayList<Action> obtenirListeAction() {
        return this.listeAction;
    }

    /**
     * Obtient la liste des transactions effectuées dans le portefeuille.
     *
     * @return Liste des transactions effectuées.
     */
    public ArrayList<Transaction> obtenirListeTransaction() {
        return this.listeTransaction;
    }

    /**
     * Obtient la liste des ordres en attente dans le portefeuille.
     *
     * @return Liste des ordres en attente.
     */
    public ArrayList<Ordre> obtenirListeOrdre() {
        return this.listeOrdre;
    }

    /**
     * Calcule et retourne le code de hachage du portefeuille. Le code de
     * hachage est basé sur le nom du propriétaire du portefeuille.
     *
     * @return Code de hachage du portefeuille.
     */
    @Override
    public int hashCode() {

        final int hash = 3;
        final int hashMultiplier = 53;

        int finalID;

        finalID = hashMultiplier * hash
                + Objects.hashCode(this.nomProprietaire);
        return finalID;
    }

    /**
     * Permet d'enlever une action du portefeuille.
     *
     * @param action
     */
    public void enleverAction(Action action) {
        this.listeAction.remove(action);
    }

    /**
     * Permet d'enlever une quantité d'acion du portefeuille.
     *
     * @param action
     * @param quantite
     */
    public void enleverQuantiteAction(Action action, int quantite) {
        for (Action actionPortefeuille : this.listeAction) {
            if (actionPortefeuille.equals(action)) {
                actionPortefeuille.enleverQuantite(quantite);
                if (actionPortefeuille.quantite < 1) {
                    actionPortefeuille.enleverAction(action);
                }
            }
        }
    }

    /**
     * Affiche les détails du portefeuille : l'identifiant, le solde, la liste
     * des actions détenues, la liste des transactions effectuées et la liste
     * des ordres en attente.
     */
    public void afficherPortefeuille() {
        System.out.println("Portefeuille : " + this.id);
        System.out.println("Solde : " + this.solde);
        System.out.println("Liste des actions : ");
        for (Action action : this.listeAction) {
            action.afficherAction();
        }
        System.out.println("Liste des transactions : ");
        for (Transaction transaction : this.listeTransaction) {
            transaction.afficherTransaction();
        }
        System.out.println("Liste des ordres : ");
        for (Ordre ordre : this.listeOrdre) {
            ordre.afficherOrdre();
        }
    }
}
