package de.akcards.card;

/**
 * Created by Frath on 30.12.2015.
 */
public abstract class AbstractCard {

    /** name of card e.g. "Willi 68" */
    private String cardName;

    /** image/texture on card as base 64 coded string */
    private String cardImage;

    /**
     * text on card e.g. "Wenn diese Karte im Schnelligkeitsmodus beschworen wird, +
     * kannst du einen weiteren Charakter beschwören"
     */
    private String cardText;

    /* type of effect e.g. ONCE (one time) for "Willi 68" */
    private EFFECT_TYPE ONE_TIME;

    // Trigger
    // Action

}
