/*
 * This file is part of LiquidBounce (https://github.com/CCBlueX/LiquidBounce)
 *
 * Copyright (c) 2015 - 2024 CCBlueX
 *
 * LiquidBounce is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * LiquidBounce is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LiquidBounce. If not, see <https://www.gnu.org/licenses/>.
 */
package net.ccbluex.liquidbounce.utils.block

import net.minecraft.block.BlockState
import net.minecraft.util.math.BlockPos
import java.util.concurrent.ConcurrentHashMap

/**
 * Tracks locations of specific blocks in the world
 *
 * @param T state type
 */
abstract class AbstractBlockLocationTracker<T> : ChunkScanner.BlockChangeSubscriber {

    val trackedBlockMap = ConcurrentHashMap<BlockPos, T>()

    abstract fun getStateFor(pos: BlockPos, state: BlockState): T?

    override fun recordBlock(pos: BlockPos, state: BlockState, cleared: Boolean) {
        val newState = this.getStateFor(pos, state)
        val targetBlockPos = pos.toImmutable()

        if (newState == null) {
            if (!cleared) {
                this.trackedBlockMap.remove(targetBlockPos)
            }

            return
        }

        this.trackedBlockMap[targetBlockPos] = newState
    }

    override fun clearChunk(x: Int, z: Int) {
        this.trackedBlockMap.entries.removeIf { (key, _) -> key.x shr 4 == x && key.z shr 4 == z }
    }

    override fun clearAllChunks() {
        this.trackedBlockMap.clear()
    }

    override fun chunkUpdate(x: Int, z: Int) {
        // Do nothing. Logic is already implemented in recordBlock
    }
}
