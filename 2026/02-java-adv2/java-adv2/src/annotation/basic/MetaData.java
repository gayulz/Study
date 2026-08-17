package annotation.basic;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 17.
 * @fileName : MetaData
 */
@AnnoMeta
public class MetaData {


    private String id;

    @AnnoMeta
    public void call(){

    }

    public static void main(String[] args) throws NoSuchMethodException {
        AnnoMeta typeAnno = MetaData.class.getAnnotation(AnnoMeta.class);
        System.out.println("typeAnno = " + typeAnno);

        AnnoMeta metaAnno = MetaData.class.getMethod("call").getAnnotation(AnnoMeta.class);
        System.out.println("metaAnno = " + metaAnno);
    }
}
