class Monsters extends Phaser.Physics.Arcade.Sprite{
    constructor(scene, x, y, texture, frame) {
        super(scene, x, y, texture, frame);
        scene.add.existing(this);
        scene.physics.add.existing(this);
        this.createAnimations(scene, texture)
        this.speed = 30
        this.hp = 50
        this.attack = 10;
        this.scene = scene
        this.gold = 100
        
    }
    //몬스터 이동 애니메이션 생성
    // createAnimations(scene, texture) {
    //     scene.anims.create({
    //         key: 'walk',
    //         frames: scene.anims.generateFrameNumbers(texture, { start: 0, end: 5 }),
    //         frameRate: 10,
    //         repeat: -1
    //     });
    // }
    
    takeDamage(gold, damage){
        this.hp -= damage
        if(this.hp <= 0){
            this.destroy()
            gold.updateGoldText(this.gold)
        }
    } 
}
class Bee extends Monsters {
    constructor(scene, x, y) {
        super(scene, x, y, 'beeD');
        this.play('wing');
        this.createAnimations(scene)

    }
    createAnimations(scene) {
        scene.anims.create({
            key: 'wing',
            frames: scene.anims.generateFrameNumbers('beeD', { start: 0, end: 5 }),
            frameRate: 10,
            repeat: -1
        });
    }
}
class Goblin extends Monsters{
    constructor(scene, x, y) {
        super(scene, x, y, 'goblinU');
        this.play('walk');
        this.hp = 75
        this.speed = 50
        this.gold = 150
    }
    createAnimations(scene) {
        scene.anims.create({
            key: 'walk',
            frames: scene.anims.generateFrameNumbers('goblinU', { start: 0, end: 5 }),
            frameRate: 10,
            repeat: -1
        });
    }
}
class Wolf extends Monsters{
    constructor(scene, x, y) {
        super(scene, x, y, 'wolfS');
        this.play('run');
        this.hp = 100
        this.speed = 100
        this.gold = 200
    }
    createAnimations(scene) {
        scene.anims.create({
            key: 'run',
            frames: scene.anims.generateFrameNumbers('wolfS', { start: 0, end: 5 }),
            frameRate: 10,
            repeat: -1
        });
    }
}
class Gold{
    constructor(scene) {
        this.scene = scene;
    }
    updateGoldText(newAmount) {
        this.scene.golds += newAmount
        this.scene.goldText.setText('Gold: ' +this.scene.golds);
    }
    countingMonster(){
        this.scene.monsterCount = 0
        this.scene.monGroup.getChildren().forEach((monster) => {
            if (
                monster.x >= 630 &&
                monster.x <= 630 + 20 &&
                monster.y >= 350 &&
                monster.y <= 350 + 20
            ) {
                this.scene.monsterCount++;
            }
        });
        this.scene.monsterCountText.setText('Attacked : ' +this.scene.monsterCount);
    }
    
}

export { Monsters, Bee, Gold, Goblin, Wolf };
