package net.brdle.rottenleather;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.brdle.rottenleather.proxy.ClientProxy;
import net.brdle.rottenleather.proxy.CommonProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("rottenleather")
public class RottenLeather
{
    public static final String MODID = "rottenleather";
    public static RottenLeather instance;
    public static CommonProxy proxy;
    private static final Logger LOGGER = LogManager.getLogger();

    public RottenLeather() {
        instance = this;

        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        proxy.start();
    }
}
