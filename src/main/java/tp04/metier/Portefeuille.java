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
public final class Portefeuille {

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
     * @param identifiant Identifiant unique du portefeuille.
     */
    public void definirId(final Integer identifiant) {
        this.id = identifiant;
    }

    /**
     * Définit le nom du propriétaire du portefeuille.
     *
     * @param designationProprietaire Nom du propriétaire du portefeuille.
     */
    public void
            definirNomProprietaire(final String designationProprietaire) {
        this.nomProprietaire = designationProprietaire;
    }

    /**
     * Définit le solde du portefeuille.
     *
     * @param montant Solde du portefeuille.
     */
    public void definirSolde(final double montant) {
        this.solde = montant;
    }

    /**
     * Ajoute une action à la liste des actions détenues dans le portefeuille.
     *
     * @param action Action à ajouter.
     */
    public void ajouterAction(final Action action) {
        this.listeAction.add(action);
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
     * Permet d'enlever une action au portefeuille.
     *
     * @param action action que nous voulons supprimer au portefeuille.
     */
    public void enleverAction(final Action action) {
        this.listeAction.remove(action);
    }

    /**
     * Permet l'ajout d'une action au portefeuille.
     *
     * @param action action que nous voulons ajouter au portefeuille.
     */
    public void ajoutAction(final Action action) {
        this.listeAction.add(action);
    }

    /**
     * Permet d'enlever une quantité d'acion du portefeuille.
     *
     * @param action action à enlever du portefeuille.
     * @param quantite quantité de l'action que nous souhaitons enlever.
     */
    public void enleverQuantiteAction(final Action action, final int quantite) {
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
    }
}
