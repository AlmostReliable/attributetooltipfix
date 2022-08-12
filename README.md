<div align="center">
<h1>Attribute Tooltip fix</h1>

A [Minecraft] mod which fix tooltip rendering for attributes, when they are loading through NBT.

[![Version][version_badge]][version_link]
[![Total Downloads][total_downloads_badge]][curseforge]
[![Workflow Status][workflow_status_badge]][workflow_status_link]
[![License][license_badge]][license]

[Discord] | [CurseForge]

</div>

## **🔧 Manually Installation**
1. Download the latest **mod jar** from [CurseForge] or the latest [releases].
2. Install Minecraft [Forge] or [Fabric].
3. Drop the mod **jar** into your mods folder.

## **✏️ Usage**
If you are using commands or something else where you need to add the UUID as NBT to add attributes, use these:
* Attack Damage: **[I;-885041709,1683771192,-1533567981,-1556236849]**
* Attack Speed: **[I;-98353636,1098926181,-1340359474,-1752847197]**

Simple example for a diamond sword:
```
/give @p diamond_sword{AttributeModifiers:[{AttributeName:"generic.attack_damage",Amount:6,Slot:mainhand,Name:"generic.attack_damage",UUID:[I;-885041709,1683771192,-1533567981,-1556236849]},{AttributeName:"generic.attack_speed",Amount:-2.4,Slot:mainhand,Name:"generic.attack_speed",UUID:[I;-98353636,1098926181,-1340359474,-1752847197]}]} 1
```

If you are using KubeJS or another mod which let's you define attributes directly through the UUID string, use these:
* Attack Damage: **CB3F55D3-645C-4F38-A497-9C13A33DB5CF**
* Attack Speed: **FA233E1C-4180-4865-B01B-BCCE9785ACA3**

## **🎓 License**
This project is licensed under the [GNU Lesser General Public License v3.0][license].

<!-- Badges -->
[version_badge]: https://img.shields.io/github/v/release/AlmostReliable/attributetooltipfix?style=flat-square
[version_link]: https://github.com/AlmostReliable/attributetooltipfix/releases/latest
[total_downloads_badge]: http://cf.way2muchnoise.eu/full_658833.svg?badge_style=flat
[workflow_status_badge]: https://img.shields.io/github/workflow/status/AlmostReliable/attributetooltipfix/CI?style=flat-square
[workflow_status_link]: https://github.com/AlmostReliable/attributetooltipfix/actions
[license_badge]: https://img.shields.io/github/license/AlmostReliable/attributetooltipfix?style=flat-square

<!-- Links -->
[minecraft]: https://www.minecraft.net/
[discord]: https://discord.com/invite/ThFnwZCyYY
[releases]: https://github.com/AlmostReliable/attributetooltipfix/releases
[curseforge]: https://www.curseforge.com/minecraft/mc-mods/attributetooltipfix
[forge]: http://files.minecraftforge.net/
[fabric]: https://fabricmc.net/
[changelog]: CHANGELOG.md
[license]: LICENSE
