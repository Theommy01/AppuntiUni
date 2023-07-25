

<?php $__env->startSection('title', 'Modifica dati personali dello staff'); ?>

<?php $__env->startSection('content'); ?>
    <div class="wrapper wrapper-register">
        <div class="form-box form-box-inputdialog">
            <h2>Modifica dati personali di: <?php echo e($dati['username']); ?></h2>

            <?php if(session('success')): ?>
                <div class="form-insertFAQ">
                    <?php echo e(session('success')); ?>

                </div>
            <?php endif; ?>
            <br>

            <?php echo csrf_field(); ?>
            <?php echo e(Form::open(array('url' => '/modificaDatiL2/', 'enctype' => 'multipart/form-data', 'method' => 'PUT'))); ?>

            <div class="form-row">
                <div class="form-left">
                    <?php echo e(Form::label('nome', 'Nome', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::text('nome', $dati['nome'], ['class' => 'input', 'id' => 'nome', 'required' => 'required'])); ?>

                    <?php if($errors->first('nome')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('nome'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('cognome', 'Cognome', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::text('cognome', $dati['cognome'], ['class' => 'input', 'id' => 'cognome', 'required' => 'required'])); ?>

                    <?php if($errors->first('cognome')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('cognome'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('eta', 'Data di nascita', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::date('eta', $dati['eta'], ['class' => 'input', 'id' => 'eta', 'rules' => 'date_format:d-m-Y', 'required' => 'required'])); ?>

                    <?php if($errors->first('eta')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('eta'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('genere', 'Sesso', ['class' => 'label-radio'])); ?>

                    <?php if($dati['genere']=="M"): ?>
                        <?php echo e(Form::radio('genere', 'M', true, ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::label('genere', 'Maschio', ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::radio('genere', 'F', false, ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::label('genere', 'Femmina', ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::radio('genere', 'A', false, ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::label('genere', 'Altro', ['style' => 'display:inline;'])); ?>

                    <?php elseif($dati['genere']=="F"): ?>
                        <?php echo e(Form::radio('genere', 'M', false, ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::label('genere', 'Maschio', ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::radio('genere', 'F', true, ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::label('genere', 'Femmina', ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::radio('genere', 'A', false, ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::label('genere', 'Altro', ['style' => 'display:inline;'])); ?>

                    <?php elseif($dati['genere']=="A"): ?>
                        <?php echo e(Form::radio('genere', 'M', false, ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::label('genere', 'Maschio', ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::radio('genere', 'F', false, ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::label('genere', 'Femmina', ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::radio('genere', 'A', true, ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::label('genere', 'Altro', ['style' => 'display:inline;'])); ?>

                    <?php else: ?>
                        <?php echo e(Form::radio('genere', 'M', false, ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::label('genere', 'Maschio', ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::radio('genere', 'F', false, ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::label('genere', 'Femmina', ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::radio('genere', 'A', false, ['style' => 'display:inline;'])); ?>

                        <?php echo e(Form::label('genere', 'Altro', ['style' => 'display:inline;'])); ?>

                    <?php endif; ?>
                    <?php if($errors->first('sesso')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('sesso'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('telefono', 'Numero di telefono', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::text('telefono', $dati['telefono'], ['class' => 'input', 'id' => 'telefono', 'rules' => 'phone', 'required' => 'required'])); ?>

                    <?php if($errors->first('telefono')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('telefono'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>
                </div>

                <div class="form-right">
                    <?php echo e(Form::label('email', 'Email', ['class' => 'label-input'])); ?>

                    <?php echo e(Form::text('email', $dati['email'], ['class' => 'input', 'id' => 'email', 'rules' => 'email', 'required' => 'required'])); ?>

                    <?php if($errors->first('email')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('email'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>

                    <?php echo e(Form::label('password', 'Password')); ?>

                    <?php echo e(Form::password('password')); ?>

                    <?php if($errors->first('password')): ?>
                        <ul class="errors">
                            <?php $__currentLoopData = $errors->get('password'); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $message): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                                <li><?php echo e($message); ?></li>
                            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                        </ul>
                    <?php endif; ?>
                </div>
            </div>

            <button type="submit" class="btn">Modifica dati</button>
            <br>

            <div class="panel-buttons">
                <a class="btn btn-back" href="<?php echo e(route('hubUtente')); ?>">Torna indietro</a>
            </div>
        </div>
<?php $__env->stopSection(); ?>

<?php echo $__env->make('layouts.skel', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?><?php /**PATH C:\Applicazioni\XAmpp\download\htdocs\ProgettoTecnologieWeb\resources\views/staff/modificaDatiL2.blade.php ENDPATH**/ ?>