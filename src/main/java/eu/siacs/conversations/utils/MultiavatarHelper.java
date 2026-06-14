package eu.siacs.conversations.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import eu.siacs.conversations.ui.MultiavatarGen;

public class MultiavatarHelper {

    /**
     * Gera um Bitmap de avatar baseado em uma semente (seed) usando o algoritmo Multiavatar.
     * 
     * @param seed Qualquer string (nome, UUID, etc) para gerar um avatar único.
     * @param size Tamanho do Bitmap (largura e altura).
     * @return Bitmap gerado ou null em caso de erro.
     */
    public static Bitmap generateAvatar(String seed, int size) {
        String svgString = MultiavatarGen.genAvatarSvg(seed);
        try {
            SVG svg = SVG.getFromString(svgString);
            Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            
            // Ajusta o SVG para o tamanho do canvas
            svg.setDocumentWidth(size);
            svg.setDocumentHeight(size);
            
            svg.renderToCanvas(canvas);
            return bitmap;
        } catch (SVGParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
