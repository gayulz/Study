class Buildings extends Phaser.Physics.Arcade.Sprite{
    constructor(scene, x, y, texture, frame) {
        super(scene, x, y, texture, frame);
        scene.add.existing(this);
        scene.physics.add.existing(this);
        this.createAnimations(scene, texture)    
        this.LastFired = 0  
        this.fireRate = 2000  
    }
    //몬스터 이동 애니메이션 생성
    createAnimations(scene, texture) {
        scene.anims.create({
            key: texture,
            frames: scene.anims.generateFrameNumbers(texture, { start: 0, end: 3 }),
            frameRate: 10,
            repeat: -1
        });
    }
}
class Tower extends Buildings {
    constructor(scene, x, y, texture) {
        super(scene, x, y, texture);
        this.play(texture);
        this.attackRange = new Phaser.Geom.Circle(x, y+10, 150); 
        let graphics = scene.add.graphics({ fillStyle: { color: 0xeffff4, alpha: 0.2 } });
        graphics.fillCircleShape(this.attackRange);
    }
}
class CampFire extends Buildings {
    constructor(scene, x, y, texture) {
        super(scene, x, y, texture);
        this.play(texture);
    }
}


export { Buildings, Tower, CampFire };