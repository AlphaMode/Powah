package owmii.powah.lib.client.wiki.page.panel;

import owmii.powah.lib.client.util.Text;

import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.BaseComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import java.util.LinkedHashMap;

public class InfoBox {
    private final LinkedHashMap<BaseComponent, BaseComponent> lines = new LinkedHashMap<>();
    public static final InfoBox EMPTY = new InfoBox();
    @Nullable
    private Style titleStyle;
    @Nullable
    private Style valueStyle;

    public InfoBox() {
    }

    public InfoBox(ChatFormatting titleStyle, ChatFormatting valueStyle) {
        this(Style.EMPTY.applyFormat(titleStyle), Style.EMPTY.applyFormat(valueStyle));
    }

    public InfoBox(int titleColor, int valueColor) {
        this(Text.color(titleColor), Text.color(valueColor));
    }

    public InfoBox(@Nullable Style titleStyle, @Nullable Style valueStyle) {
        this.titleStyle = titleStyle;
        this.valueStyle = valueStyle;
    }

    public void set(BaseComponent title, BaseComponent value) {
        this.lines.put(title, value);
    }

    @Nullable
    private Style getTitleStyle() {
        return this.titleStyle;
    }

    public InfoBox setTitleStyle(@Nullable Style titleStyle) {
        this.titleStyle = titleStyle;
        return this;
    }

    @Nullable
    private Style getValueStyle() {
        return this.valueStyle;
    }

    public InfoBox setValueStyle(@Nullable Style valueStyle) {
        this.valueStyle = valueStyle;
        return this;
    }

    public LinkedHashMap<BaseComponent, BaseComponent> getLines() {
        return this.lines;
    }

    public interface IInfoBoxHolder {
        InfoBox getInfoBox(ItemStack stack, InfoBox box);
    }
}
