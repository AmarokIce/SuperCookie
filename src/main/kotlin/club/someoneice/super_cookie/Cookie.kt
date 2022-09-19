package club.someoneice.super_cookie

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemPickaxe
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class Cookie(private val material: ToolMaterial?, name: String) : ItemPickaxe(material) {
    init {
        setTextureName(SuperCookieMain.MODID + ":" + name)
        unlocalizedName = name
        GameRegistry.registerItem(this, name, SuperCookieMain.MODID)
    }

    override fun onEaten(itemStack: ItemStack?, world: World, player: EntityPlayer?): ItemStack? {
        super.onEaten(itemStack, world, player)

        itemStack?.itemDamage?.plus(2)!!
        player?.foodStats?.addStats(3, 3.0f)

        return itemStack
    }

    override fun onItemRightClick(itemStack: ItemStack?, world: World?, player: EntityPlayer): ItemStack? {
        super.onItemRightClick(itemStack, world, player)

        player.canEat(true)
        player.setItemInUse(itemStack, getMaxItemUseDuration(itemStack))

        return itemStack
    }

    override fun getDigSpeed(itemstack: ItemStack, block: Block, metal: Int): Float {
        return when(material) {
            ToolMaterial.IRON -> efficiencyOnProperMaterial + 5.0f
            ToolMaterial.GOLD -> efficiencyOnProperMaterial + 11.5f
            ToolMaterial.EMERALD -> efficiencyOnProperMaterial + 9.5f
            else -> efficiencyOnProperMaterial + 3.0f
        }
    }
}