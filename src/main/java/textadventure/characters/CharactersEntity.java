package textadventure.characters;

abstract class CharactersEntity {
    private String name;
    private Integer hp;
    private Integer maxHp;
    private Integer dmg;

    public abstract void printStats();


    // Getter and Setter
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Integer getHp() {return hp;}
    public void setHp(Integer hp) {this.hp = hp;}
    public Integer getMaxHp() {return maxHp;}
    public void setMaxHp(Integer maxHp) {this.maxHp = maxHp;}
    public Integer getDmg() {return dmg;}
    public void setDmg(Integer dmg) {this.dmg = dmg;}
}
