package club.someoneice.super_cookie

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import scala.reflect.internal.Trees.Super


@Mod(modid = SuperCookieMain.MODID, version = SuperCookieMain.VERSION, dependencies = "required-after:legacymckotlin")
class SuperCookieMain {
    companion object {
        const val MODID: String = "cookie"
        const val VERSION: String = "1.0.0"
    }

    val SuperCookie = Cookie(Item.ToolMaterial.STONE, "super_cookie")
    val IronSuperCookie = Cookie(Item.ToolMaterial.IRON, "iron_super_cookie")
    val GoldSuperCookie = Cookie(Item.ToolMaterial.GOLD, "gold_super_cookie")
    val DmSuperCookie = Cookie(Item.ToolMaterial.EMERALD, "diamond_super_cookie")

    val IronSuperPineapple = Cookie(Item.ToolMaterial.IRON, "iron_super_pineapple")
    val GoldSuperPineapple = Cookie(Item.ToolMaterial.GOLD, "gold_super_pineapple")
    val DmSuperPineapple = Cookie(Item.ToolMaterial.EMERALD, "diamond_super_pineapple")

    @Mod.Instance
    var instance: SuperCookieMain? = null

    @EventHandler
    fun init(event: FMLInitializationEvent) {
        GameRegistry.addRecipe(ItemStack(SuperCookie), " # ", "###", " # ", '#', Items.cookie)
        GameRegistry.addRecipe(ItemStack(IronSuperCookie), " # ", "#C#", " # ", '#', Items.iron_ingot, 'C', SuperCookie)
        GameRegistry.addRecipe(ItemStack(GoldSuperCookie), " # ", "#C#", " # ", '#', Items.gold_ingot, 'C', IronSuperCookie)
        GameRegistry.addRecipe(ItemStack(DmSuperCookie), " # ", "#C#", " # ", '#', Items.diamond, 'C', GoldSuperCookie)

        GameRegistry.addRecipe(ItemStack(IronSuperPineapple), "B#B", "#C#", "B#B", '#', Items.iron_ingot, 'C', SuperCookie, 'B', Items.bone)
        GameRegistry.addRecipe(ItemStack(GoldSuperPineapple), " # ", "#C#", " # ", '#', Items.gold_ingot, 'C', IronSuperPineapple)
        GameRegistry.addRecipe(ItemStack(DmSuperPineapple), " # ", "#C#", " # ", '#', Items.diamond, 'C', GoldSuperPineapple)


    }

    @EventHandler
    fun perInit(event: FMLPreInitializationEvent) {

    }

    @EventHandler
    fun serverStarting(event: FMLServerStartingEvent) {

    }
}
