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
 *
 */
package net.ccbluex.liquidbounce.integration.interop.protocol.rest.v1

import net.ccbluex.liquidbounce.integration.interop.protocol.rest.v1.client.*
import net.ccbluex.liquidbounce.integration.interop.protocol.rest.v1.features.*
import net.ccbluex.liquidbounce.integration.interop.protocol.rest.v1.game.*
import net.ccbluex.netty.http.rest.Node

internal fun registerInteropFunctions(node: Node) = node.withPath("/api/v1/client") {
    // Client Functions
    get("/info", ::getClientInfo)
    get("/update", ::getUpdateInfo)
    post("/exit", ::postExit)
    get("/window", ::getWindowInfo)
    post("/browse", ::postBrowse)

    // LocalStorage Functions
    get("/localStorage/all", ::getAllLocalStorage)
    put("/localStorage/all", ::putAllLocalStorage)
    get("/localStorage", ::getLocalStorage)
    put("/localStorage", ::putLocalStorage)
    delete("/localStorage", ::deleteLocalStorage)

    // Theme Functions
    get("/theme", ::getThemeInfo)
    post("/shader", ::postToggleShader)

    // VirtualScreen Functions
    get("/virtualScreen", ::getVirtualScreenInfo)
    get("/screen", ::getScreenInfo)
    get("/screen/size", ::getScreenSize)
    put("/screen", ::putScreen)

    // Module Functions
    get("/modules", ::getModules)
    put("/modules/toggle", ::toggleModule)
    delete("/modules/toggle", ::toggleModule)
    post("/modules/toggle", ::toggleModule)
    get("/modules/settings", ::getSettings)
    put("/modules/settings", ::putSettings)
    post("/modules/panic", ::postPanic)

    // Component Functions
    get("/components", ::getComponents)

    // Session Functions
    get("/session", ::getSessionInfo)
    get("/location", ::getLocationInfo)

    // Account Functions
    get("/accounts", ::getAccounts)
    post("/accounts/new/microsoft", ::postNewMicrosoftAccount)
    post("/accounts/new/microsoft/clipboard", ::postClipboardMicrosoftAccount)
    post("/accounts/new/cracked", ::postNewCrackedAccount)
    post("/accounts/new/session", ::postNewSessionAccount)
    post("/accounts/new/altening", ::postNewAlteningAccount)
    post("/accounts/new/altening/generate", ::postGenerateAlteningAccount)
    post("/accounts/swap", ::postSwapAccounts)
    post("/accounts/order", ::postOrderAccounts)
    delete("/account", ::deleteAccount)
    post("/account/login", ::postLoginAccount)
    post("/account/login/cracked", ::postLoginCrackedAccount)
    post("/account/login/session", ::postLoginSessionAccount)
    post("/account/restore", ::postRestoreInitial)
    put("/account/favorite", ::putFavoriteAccount)
    delete("/account/favorite", ::deleteFavoriteAccount)

    // Proxy Functions
    get("/proxy", ::getProxyInfo)
    post("/proxy", ::postProxy)
    delete("/proxy", ::deleteProxy)
    get("/proxies", ::getProxies)
    post("/proxies/add", ::postAddProxy)
    post("/proxies/clipboard", ::postClipboardProxy)
    post("/proxies/edit", ::postEditProxy)
    post("/proxies/check", ::postCheckProxy)
    delete("/proxies/remove", ::deleteRemoveProxy)
    put("/proxies/favorite", ::putFavoriteProxy)
    delete("/proxies/favorite", ::deleteFavoriteProxy)

    // Browser Functions
    get("/browser", ::getBrowserInfo)
    post("/browser/navigate", ::postBrowserNavigate)
    post("/browser/close", ::postBrowserClose)
    post("/browser/reload", ::postBrowserReload)
    post("/browser/forceReload", ::postBrowserForceReload)
    post("/browser/forward", ::postBrowserForward)
    post("/browser/back", ::postBrowserBack)
    post("/browser/closeTab", ::postBrowserCloseTab)

    // Container Functions
    // TODO: Not being used but should be re-implemented in the future

    // Protocol Functions
    get("/protocols", ::getProtocols)
    get("/protocol", ::getProtocol)
    put("/protocol", ::putProtocol)
    delete("/protocol", ::deleteProtocol)

    // Reconnect Functions
    post("/reconnect", ::postReconnect)

    // Input Functions
    get("/input", ::getInputInfo)
    get("/keybinds", ::getKeybinds)

    // Player Functions
    get("/player", ::getPlayerData)

    // Registry Functions
    get("/registries", ::getRegistries)

    // ServerList Functions
    get("/servers", ::getServers)
    put("/servers/add", ::putAddServer)
    delete("/servers/remove", ::deleteServer)
    put("/servers/edit", ::putEditServer)
    post("/servers/swap", ::postSwapServers)
    post("/servers/order", ::postOrderServers)
    post("/servers/connect", ::postConnect)

    // Texture Functions
    get("/resource", ::getResource)
    get("/itemTexture", ::getItemTexture)
    get("/skin", ::getSkin)

    // World Functions
    get("/worlds", ::getWorlds)
    post("/worlds/join", ::postJoinWorld)
    post("/worlds/edit", ::postEditWorld)
    post("/worlds/delete", ::postDeleteWorld)
}
