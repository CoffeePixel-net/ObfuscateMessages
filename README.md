# 💀 **ObfuscateDeathMessages**

**ObfuscateDeathMessages** is a simple, lightweight plugin that hides the identity of invisible killers in death messages. Perfect for SMPs, PvP servers, stealth-based game modes, or any server where players can gain invisibility to avoid being immediately identified.

This plugin ensures that **if the killer is invisible**, their name in the death message is replaced with an obfuscated, configurable pattern.

---

## ✨ What It Does

Whenever a player dies, the plugin checks:

* **Who killed them** (player or mob)
* **Whether the killer is invisible**
* Whether the killer has a **bypass permission**

If the killer *is invisible* and does *not* have the bypass permission, their name in the death message is replaced with a configurable obfuscated string.

Example:

```
Player123 was slain by &f§k????§r
```

---

## 🎭 Example Uses

* Stealth-based PvP events
* Assassins game modes
* SMP servers where invisibility potions create mystery
* RPG worlds with cloaking mobs or bosses
* Servers that want more suspense and less instant information

---

## ⚙ Configuration

`config.yml`:

```yaml
obfuscation-format: "&k????&r"
```

Supports:

* Color codes (`&a`, `&c`, etc.)
* `&k` magic text
* `%name%` placeholder
* Full customization of the obfuscated output

---

## 🔑 Permissions

| Permission          | Description                                           |
| ------------------- | ----------------------------------------------------- |
| `obfusdeath.bypass` | Prevents your name from being obfuscated if invisible |

Useful for staff, testers, or special roles.

---

## 📦 Features Summary

* Obfuscates *only* invisible killers
* Works with player killers and mob killers
* Fully configurable formatting
* Supports `%name%` placeholder
* Lightweight & optimized
* Zero dependencies
* Compatible with all server types (SMP, PvP, minigames)

---
