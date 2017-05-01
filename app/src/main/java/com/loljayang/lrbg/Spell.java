package com.loljayang.lrbg;

/**
 * Created by yjj781265 on 4/27/2017.
 */

class Spell {
    private int spell;
    private String spellName;
    public Spell(int spell,String spellName){
        this.spell = spell;
        this.spellName = spellName;
    }

    public String getSpellName() {
        return spellName;
    }

    public int getSpell() {

        return spell;
    }
}
