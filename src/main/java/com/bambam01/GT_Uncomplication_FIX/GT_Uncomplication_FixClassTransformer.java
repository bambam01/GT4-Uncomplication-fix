package com.bambam01.GT_Uncomplication_FIX;

import org.objectweb.asm.Opcodes;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.*;



public class GT_Uncomplication_FixClassTransformer implements IClassTransformer {

    @Override
    public byte[] transform(String name, String transformedName, byte[] classBeingTransformed) {

        if (transformedName.equals("aroma1997.uncomplication.enet.EnergyNetLocal")){
            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(classBeingTransformed);
            classReader.accept(classNode, 0);


            for (MethodNode mn : classNode.methods) {

                if (mn.name.equals("emitEnergyFrom")) {

                    for (AbstractInsnNode ain : mn.instructions.toArray()) {
                        if (ain.getOpcode() == Opcodes.INVOKEINTERFACE) {
                            MethodInsnNode node = (MethodInsnNode) ain;
                            if(node.name.equals("injectEnergy")){


                                mn.instructions.insertBefore(node, new VarInsnNode(Opcodes.ILOAD, 24));
                                node.desc = "(Lnet/minecraftforge/common/util/ForgeDirection;DDI)D";
                                System.out.println("finished patching function emitEnergyFrom");

                            }
                        }
                    }
                }
            }

            ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            classNode.accept(classWriter);
            return classWriter.toByteArray();
        }
        return classBeingTransformed;
    }
}
