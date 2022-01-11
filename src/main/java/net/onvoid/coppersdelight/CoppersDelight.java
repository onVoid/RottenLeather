package net.onvoid.coppersdelight;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.onvoid.coppersdelight.proxy.ClientProxy;
import net.onvoid.coppersdelight.proxy.CommonProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("coppersdelight")
public class CoppersDelight
{
    public static final String MODID = "coppersdelight";
    public static CoppersDelight instance;
    public static CommonProxy proxy;
    private static final Logger LOGGER = LogManager.getLogger();

    public CoppersDelight() {
        instance = this;

        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        proxy.start();
    }
}
