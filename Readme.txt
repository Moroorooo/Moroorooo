Thanks for purchasing RimWorld! This file contains some useful miscellaneous info. Please be sure to read the EULA.txt included alongside this file before playing, and see Licenses.txt for license info on software we used.

============================================================
=============== Where's my save data? ======================
============================================================

To find saved games or config data:

1. Start the game.
2. Open the options menu.
3. Click "open save data folder".

Or look in this folder, depending on your operating system:

WINDOWS:    C:/Users/[username]/AppData/LocalLow/Ludeon Studios/RimWorld/   (Note the AppData folder may be hidden)
MAC:        /Users/[username]/Library/Application Support/RimWorld/
LINUX:      /home/[username]/.config/unity3d/Ludeon Studios/RimWorld/

Deleting config files will reset them. This can be useful if the game won't start.

For debugging and troubleshooting, the output_log.txt file is in the _Data folder in the game install folder.

Why is it like this? Modern operating systems separate changing data from program installations for several reasons:
    -First, it allows different users to have different save and config data.
    -Second, it enhances security, because it allows the program to run without having permission to write to disk anywhere outside its own little save folder.

OVERRIDING:
You can override the save data folder. This is useful, for example, if you want to install the game on a USB stick so you can plug and play it from anywhere. To do this, add this to the end of the command line used to launch the game:

    -savedatafolder=C:/Path/To/The/Folder

So it'll look something like this:

    C:/RimWorld/RimWorld.exe -savedatafolder=C:/Path/To/The/Folder

If you don't start the path with anything, it'll be relative to the game's root folder. So you could do this, to have the game save data in a folder called SaveData in its own root folder:

    -savedatafolder=SaveData

If there are spaces in the path, you'll need to surround the command with quotes:

    "-savedatafolder=Save Data"

Be sure the game is running with permission to modify the folder. It may not work properly if, for example, you run the game under default permissions on its own install folder.

============================================================
====================== Modding =============================
============================================================

For info on how to mod, see:

-The RimWorld wiki modding page: http://rimworldwiki.com/wiki/Modding
-The Modding forum: http://ludeon.com/forums/index.php?board=12.0
-The modding help forum: http://ludeon.com/forums/index.php?board=14.0

A partial source release is included with the game in the Source folder. Here you'll find a few of the source files for the base game for your reference. You can also decompile the whole game using a .NET decompiler like dotPeek or ILSpy.

For testing, you can start the game into a tiny (fast-loading) map with one click by running the game with the -quicktest command line parameter. For example:

    C:/RimWorld/RimWorld.exe -quicktest

If you're a modder, we recommend making a shortcut to the game that does this.

============================================================
=================== Help Translate! ========================
============================================================

RimWorld comes with a number of translations. All non-English translations are fan-made.

If you have another language to add or something to correct in an existing translation, you can! Check out the fan translation hub on the forum here:

http://ludeon.com/forums/index.php?board=17.0